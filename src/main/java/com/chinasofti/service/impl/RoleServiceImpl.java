package com.chinasofti.service.impl;

import com.chinasofti.dao.RoleDao;
import com.chinasofti.entity.Role;
import com.chinasofti.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public RoleServiceImpl() {
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> selectAllRoleService() {
        return roleDao.selectAllRole();
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public void delete(Integer id) {
        roleDao.delete(id);
    }

    @Override
    public void deleteSur(Integer id) {
        roleDao.deleteSur(id);
    }
}
