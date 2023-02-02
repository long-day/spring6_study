package me.longday.ioc;

import me.longday.ioc.context.AnnotationApplicationContext;
import me.longday.ioc.controller.UserController;

/**
 * @author 君
 * @version 1.0
 * @desc test
 * @since 2023/2/2
 */
public class IocTest {
    public static void main(String[] args) {
        AnnotationApplicationContext context =
                new AnnotationApplicationContext("me.longday.ioc");
        UserController userController = context.getLdBean(UserController.class);
        userController.showMsg();
    }
}
