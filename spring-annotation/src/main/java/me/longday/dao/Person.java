package me.longday.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 君
 * @version 1.0
 * @desc Person
 * @since 2023/2/1
 */
@Component
public class Person {
    String username;
    Integer age;
    public static final Logger log = LoggerFactory.getLogger(Person.class);
    public void showInfo(){
        log.info("person name = {},age = {}",username,age);
    }
}
