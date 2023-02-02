package me.longday.ioc.dao;

import lombok.extern.slf4j.Slf4j;
import me.longday.ioc.annotation.LdBean;

/**
 * @author 君
 * @version 1.0
 * @desc User
 * @since 2023/2/1
 */
@Slf4j
@LdBean
public class User {
    String name;
    public void showMsg(){
        log.info("==== User ====");
        log.info("这里是Msg user name = {}",name);
        log.info("==== User ====");

    }
}
