package me.longday.spring.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 君
 * @version 1.0
 * @desc 用户类
 * @since 2023/2/1
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User{
    Long id;
    String username;
    String phone;
    Integer age;
    public static final Logger log = LoggerFactory.getLogger(User.class);


    public void showUserInfo(){
        log.info("User id = {},username = {},phone = {},age = {}",id,username,phone,age);
    }
}
