package com.chinasofti.service.impl;

import com.chinasofti.dao.RoleDao;
import com.chinasofti.dao.UserDao;
import com.chinasofti.dao.impl.UserDaoImpl;
import com.chinasofti.entity.Role;
import com.chinasofti.entity.User;
import com.chinasofti.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

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

    //查看所有的user
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

    @Override
    public User login(String name, String pwd) {
        User user = null;
        try {
            user = userDao.findUserByNameAndPwd(name, pwd);
        }catch (EmptyResultDataAccessException em){
            return null;
        }
        return user;
    }


    @Override
    public List<Role> selectUserByRole() {
        return userDao.selectUserByRole();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void addUserByRole(User user,List<Integer> roleIds) {
        userDao.addUserByRole(user,roleIds);
    }

    @Override
    public void deleteUser(Integer uid) {
        userDao.deleteUser(uid);
    }

    @Override
    public void deleteUserByRole(Integer uid) {
        userDao.deleteUserByRole(uid);
    }
}
