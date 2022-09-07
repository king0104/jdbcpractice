package com.example.jdbcpractice;

import com.example.jdbcpractice.dao.RoleDao;
import com.example.jdbcpractice.dto.Role;

public class JdbcExamSelect {
    public static void main(String[] args) {
        RoleDao dao = new RoleDao();
        Role role = dao.getRole(100);
        System.out.println(role);

    }
}
