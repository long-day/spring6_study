package me.longday.ioc.controller;

import lombok.extern.slf4j.Slf4j;
import me.longday.ioc.annotation.Di;
import me.longday.ioc.annotation.LdBean;
import me.longday.ioc.service.UserService;

/**
 * @author 君
 * @version 1.0
 * @desc controller
 * @since 2023/2/1
 */
@Slf4j
@LdBean
public class UserController {

    @Di
    private UserService userService;
    public void showMsg(){
        log.info("==== UserController ====");
        userService.showMsg();
        log.info("==== UserController ====");

    }

}
