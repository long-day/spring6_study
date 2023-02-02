package me.longday.ioc.context;

import lombok.extern.slf4j.Slf4j;
import me.longday.ioc.annotation.Di;
import me.longday.ioc.annotation.LdBean;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 君
 * @version 1.0
 * @desc 具体容器
 * @since 2023/2/1
 */
@Slf4j
public class AnnotationApplicationContext implements ApplicationContext{
    private static Map<Class,Object> beanMap = new HashMap<>(16);
    private static String rootPath;

    public AnnotationApplicationContext(String basePackagePath){
        String basePath = basePackagePath.replaceAll("\\.", "\\\\");
        try {
            Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(basePath);
            rootPath = this.getClass().getResource("/").getPath();
            while (dirs.hasMoreElements()){
                URL url = dirs.nextElement();
                String path = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
                loadLdBean(new File(path));
            }
            loadDi();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void loadLdBean(File file){
        if(file.isDirectory()){
            File[] childFiles = file.listFiles();
            if(childFiles==null || childFiles.length == 0){
                return;
            }
            for (File childFile : childFiles) {
                loadLdBean(childFile);
            }
        }else {
            String pathWithClass = file.getAbsolutePath().substring(rootPath.length() - 5);
            if (pathWithClass.contains(".class")) {
                String fullName = pathWithClass
                        .replaceAll("\\\\", ".")
                        .replace(".class","");

                try {
                    Class<?> clazz = Class.forName(fullName);
                    if (!clazz.isInterface()){
                        LdBean annotation = clazz.getAnnotation(LdBean.class);
                        if(annotation == null){
                            return;
                        }
                        Object obj = clazz.getConstructor().newInstance();

                        if(clazz.getInterfaces().length>0){
                            beanMap.put(clazz.getInterfaces()[0],obj);

                        }else {
                            beanMap.put(clazz,obj);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

    private static void  loadDi() throws IllegalAccessException {
        Set<Map.Entry<Class, Object>> entries = beanMap.entrySet();
        for (Map.Entry<Class, Object> entry : entries) {
            Object obj = entry.getValue();
            Class<?> objClazz = obj.getClass();
            Field[] fields = objClazz.getDeclaredFields();

            for (Field field : fields) {
                Di annotation = field.getAnnotation(Di.class);
                if (annotation != null){
                    field.setAccessible(true);
                    field.set(obj,beanMap.get(field.getType()));
                }
            }
        }
    }
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getLdBean(Class<T> clazz) {
        Object instance = beanMap.get(clazz);
        if (instance != null) {
            if (clazz != null && !clazz.isInstance(instance)) {
                log.error("get bean error");
                return null;
            }
            return (T) instance;
        }
        return null;
    }
}
