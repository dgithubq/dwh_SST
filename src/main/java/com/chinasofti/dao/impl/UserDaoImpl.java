package com.chinasofti.dao.impl;

import com.chinasofti.dao.UserDao;
import com.chinasofti.entity.Role;
import com.chinasofti.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> selectUsers() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findUserByNameAndPwd(String name, String pwd) throws EmptyResultDataAccessException {
        return jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?", new BeanPropertyRowMapper<User>(User.class), name, pwd);
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update("insert into sys_user(userName,email,password,phoneNum) values(?,?,?,?)", user.getUserName(), user.getPassWord(), user.getEmail(), user.getPhoneNum());
    }

    @Override
    public void addUserByRole(User user, List<Integer> roleIds) {
        Integer userId = jdbcTemplate.queryForObject("select * from sys_user where username = ?", new BeanPropertyRowMapper<>(User.class), user.getUserName()).getId();
        for (Integer roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?) ", userId,roleId);
        }
    }
}
