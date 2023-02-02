package me.longday.bean;

import me.longday.dao.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author 君
 * @version 1.0
 * @desc PersonTest
 * @since 2023/2/1
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean.xml")
public class PersonTest {
    @Autowired
    Person person;
    @Test
    void test1(){
        person.showInfo();
    }
}
