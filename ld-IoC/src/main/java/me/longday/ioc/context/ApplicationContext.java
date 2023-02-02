package me.longday.ioc.context;

/**
 * @author 君
 * @version 1.0
 * @desc 容器接口
 * @since 2023/2/1
 */
public interface ApplicationContext {
     <T> T getLdBean(Class<T> clazz);
}
