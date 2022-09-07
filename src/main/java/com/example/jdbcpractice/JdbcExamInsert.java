package com.example.jdbcpractice;

import com.example.jdbcpractice.dao.RoleDao;
import com.example.jdbcpractice.dto.Role;

public class JdbcExamInsert {
    public static void main(String[] args) {
        int id = 500;
        String description = "ceo";

        Role role = new Role(id, description);

        RoleDao roleDao = new RoleDao();
        int updateCount = roleDao.updateRole(role);

        System.out.println(updateCount);

    }
}
