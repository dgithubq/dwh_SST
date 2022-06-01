package com.chinasofti.service;

import com.chinasofti.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectUsers();
    //根据名字密码登陆用户
    User login(String name,String pwd);

    void add(User user);//新增用户
    void addUserByRole(User user,List<Integer> roleIds);//新增sys_user_role

    void deleteUser(Integer uid);
    void deleteUserByRole(Integer uid);
}
