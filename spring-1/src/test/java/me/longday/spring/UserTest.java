package me.longday.spring;

import me.longday.spring.dao.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 君
 * @version 1.0
 * @desc User测试类
 * @since 2023/2/1
 */
public class UserTest {
    @Test
    void test1(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-spring.xml");
        User user = context.getBean("user", User.class);
        user.showUserInfo();
    }
}
