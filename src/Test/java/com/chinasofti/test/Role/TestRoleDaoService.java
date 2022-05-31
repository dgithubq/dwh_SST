package com.chinasofti.test.Role;

import com.chinasofti.dao.RoleDao;
import com.chinasofti.entity.Role;
import com.chinasofti.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestRoleDaoService {
    ClassPathXmlApplicationContext context = null;
    RoleService roleService = null;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        roleService =(RoleService) context.getBean("roleService");
    }

    @Test
    public void testRoleServiceAll(){
        List<Role> roles = roleService.selectAllRoleService();
        System.out.println("roles = " + roles);
    }

    @Test
    public void testRoleAdd(){
        roleService.add(new Role(null,"dwh","roledesc"));
        System.out.println("context = " + context);
    }

    @Test
    public void testDelete(){
        roleService.deleteSur(2);
        roleService.delete(2);
        System.out.println("context = " + context);
    }
}
