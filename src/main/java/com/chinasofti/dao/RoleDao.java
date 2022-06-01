package com.chinasofti.dao;

import com.chinasofti.entity.Role;
import com.sun.rowset.JdbcRowSetImpl;

import java.util.List;

public interface RoleDao {
    List<Role> selectAllRole();

    void add(Role role);

    void delete(Integer id);//删除sys_role

    void deleteSur(Integer id);//删除sys_user_role

    List<Role> selectUserById(Integer id);

}
