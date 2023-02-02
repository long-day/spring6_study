package me.longday.ioc.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.longday.ioc.annotation.Di;
import me.longday.ioc.annotation.LdBean;
import me.longday.ioc.dao.User;
import me.longday.ioc.service.UserService;

/**
 * @author 君
 * @version 1.0
 * @desc 业务层
 * @since 2023/2/1
 */
@Slf4j
@LdBean
public class UserServiceImpl implements UserService {
    @Di
    private User user;
    @Override
    public void showMsg() {
        log.info("==== UserServiceImpl ====");
        user.showMsg();
        log.info("==== UserServiceImpl ====");

    }
}
