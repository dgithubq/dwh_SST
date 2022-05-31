package com.chinasofti.test.User;

import com.chinasofti.entity.Role;
import com.chinasofti.entity.User;
import com.chinasofti.service.RoleService;
import com.chinasofti.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestUserDaoService {
    ClassPathXmlApplicationContext context = null;
    UserService userService = null;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService =(UserService) context.getBean("userService");
    }

    @Test
    public void testRoleServiceAll(){
        List<User> users = userService.selectUsers();
        System.out.println("users = " + users);
    }

//    @Test
//    public void testRoleAdd(){
//        roleService.add(new Role(null,"dwh","roledesc"));
//        System.out.println("context = " + context);
//    }

//    @Test
//    public void testDelete(){
//        roleService.deleteSur(2);
//        roleService.delete(2);
//        System.out.println("context = " + context);
//    }
}
