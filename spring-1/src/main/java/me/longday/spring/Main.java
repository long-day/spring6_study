package me.longday.spring;

import me.longday.spring.dao.User;

/**
 * @author 君
 * @version 1.0
 * @desc
 * @since 2023/2/1
 */
public class Main {
    public static void main(String[] args) {
        User user = new User(1L, "宝宝", "18738033333", 18);
        user.showUserInfo();
    }
}
