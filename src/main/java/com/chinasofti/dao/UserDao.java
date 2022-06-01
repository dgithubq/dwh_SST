package com.chinasofti.dao;

import com.chinasofti.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectUsers();
    //根据输入的名称和密码获得用户属性
    User findUserByNameAndPwd(String name,String pwd);

    //新增新用户
    void add(User user);
    //添加到sys_user_role
    void addUserByRole(User user,List<Integer> roleIds);
    void deleteUser(Integer uid);
    void deleteUserByRole(Integer uid);
}
