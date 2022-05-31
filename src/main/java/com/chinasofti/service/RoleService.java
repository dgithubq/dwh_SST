package com.chinasofti.service;

import com.chinasofti.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> selectAllRoleService();

    void delete(Integer id);

    void deleteSur(Integer id);

    void add(Role role);
}
