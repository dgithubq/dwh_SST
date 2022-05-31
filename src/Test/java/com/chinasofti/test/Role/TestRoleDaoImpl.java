package com.chinasofti.test.Role;

import com.chinasofti.dao.RoleDao;
import com.chinasofti.entity.Role;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestRoleDaoImpl {
    ClassPathXmlApplicationContext context = null;
    RoleDao roleDao = null;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        roleDao =(RoleDao) context.getBean("roleDao");
    }

    @Test
    public void testRoleDao(){
        List<Role> roles = roleDao.selectAllRole();
        System.out.println("roles = " + roles);
    }

    @Test
    public void testRoleDaAdd(){
        roleDao.add(new Role(null,"dwh2","rolD"));
        System.out.println("context = " + context);
    }

    @Test
    public void testDelate(){
        roleDao.deleteSur(3);
        roleDao.delete(3);
        System.out.println("context = " + context);
    }
}
