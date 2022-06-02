package com.chinasofti.test.User;

import com.chinasofti.dao.RoleDao;
import com.chinasofti.dao.UserDao;
import com.chinasofti.dao.impl.UserDaoImpl;
import com.chinasofti.entity.Role;
import com.chinasofti.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestUserDaoImpl {
    ClassPathXmlApplicationContext context = null;
    UserDao userDao = null;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao = (UserDao) context.getBean("userDao");
    }

    @Test
    public void testUserDaoSelect() {
        List<User> users = userDao.selectUsers();
        System.out.println("users = " + users);
    }


    @Test
    public void testFindUserByNameAndPwd(){
        User user = userDao.findUserByNameAndPwd("lisi", "123");
        System.out.println("user = " + user);
    }

    //添加用户
    @Test
    public void testAdd(){
        User user = new User("dwh", "123", "1323233232@qq.com", "123213444444");
        List<Integer> objects = new ArrayList<>();
        objects.add(1);
        userDao.add(user);
        userDao.addUserByRole(user,objects);
        System.out.println("context = " + context);
    }

    //删除用户
    @Test
    public void testDeleteUser(){
        userDao.deleteUserByRole(12);
        userDao.deleteUser(12);
        System.out.println("context = " + context);
    }

    @Test
    public void testUserByRole(){
        List<Role> roles = userDao.selectUserByRole();
        System.out.println("roles = " + roles);
    }
}
