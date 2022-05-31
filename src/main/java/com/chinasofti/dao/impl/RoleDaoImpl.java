package com.chinasofti.dao.impl;

import com.chinasofti.dao.RoleDao;
import com.chinasofti.entity.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RoleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RoleDaoImpl() {
    }

    @Override
    public List<Role> selectAllRole() {
        return jdbcTemplate.query("select * from sys_role",new BeanPropertyRowMapper<Role>(Role.class));
    }

    @Override
    public void add(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)",role.getId(),role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from sys_role where sys_role.id = ?",id);
    }

    @Override
    public void deleteSur(Integer id) {
        jdbcTemplate.update("delete from sys_user_role where roleId = ?",id);
    }

    @Override
    public List<Role> selectUserById(Integer userid) {
        return jdbcTemplate.query("select * from sys_role sr,sys_user_role sur where sr.id = sur.roleId and sur.roleId = ?",new BeanPropertyRowMapper<Role>(Role.class),userid);
    }
}
