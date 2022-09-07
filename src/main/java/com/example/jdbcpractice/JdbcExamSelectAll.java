package com.example.jdbcpractice;

import com.example.jdbcpractice.dao.RoleDao;
import com.example.jdbcpractice.dto.Role;

import java.util.List;

public class JdbcExamSelectAll {
    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        List<Role> roles = roleDao.getRoles();

        for (Role role : roles) {
            System.out.println("role = " + role);
        }
    }
}
