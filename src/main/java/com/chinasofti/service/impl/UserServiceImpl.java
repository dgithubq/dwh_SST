package com.chinasofti.service.impl;

import com.chinasofti.dao.RoleDao;
import com.chinasofti.dao.UserDao;
import com.chinasofti.dao.impl.UserDaoImpl;
import com.chinasofti.entity.Role;
import com.chinasofti.entity.User;
import com.chinasofti.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    public UserServiceImpl() {
    }

    @Override
    public List<User> selectUsers() {
        List<User> users = userDao.selectUsers();
        for (User user:users){
            Integer id = user.getId();
            List<Role> roles = roleDao.selectUserById(id);
            user.setRoles(roles);
        }
        return users;
    }
}
