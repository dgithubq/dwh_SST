package com.chinasofti.dao;

import com.chinasofti.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectUsers();
}
