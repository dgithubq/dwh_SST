package com.chinasofti.service;

import com.chinasofti.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectUsers();
    //根据名字密码登陆用户
    User login(String name,String pwd);
}
