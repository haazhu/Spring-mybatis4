package com.test;

import com.config.SpringConfig;
import com.dao.UserDao;
import com.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = context.getBean(UserDao.class);
        List<User> users = userDao.select();
        System.out.println(users);
    }
}
