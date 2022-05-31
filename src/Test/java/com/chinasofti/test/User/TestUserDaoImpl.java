package com.chinasofti.test.User;

import com.chinasofti.dao.RoleDao;
import com.chinasofti.dao.UserDao;
import com.chinasofti.entity.Role;
import com.chinasofti.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

//    @Test
//    public void testRoleDaAdd(){
//        roleDao.add(new Role(null,"dwh2","rolD"));
//        System.out.println("context = " + context);
//    }

//    @Test
//    public void testDelate(){
//        roleDao.deleteSur(3);
//        roleDao.delete(3);
//        System.out.println("context = " + context);
//    }
}
