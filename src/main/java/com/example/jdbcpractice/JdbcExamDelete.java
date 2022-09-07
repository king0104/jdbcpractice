package com.example.jdbcpractice;

import com.example.jdbcpractice.dao.RoleDao;

public class JdbcExamDelete {
    public static void main(String[] args) {
        int id = 500;

        RoleDao roleDao = new RoleDao();
        int deleteCount = roleDao.deleteRole(id);

        System.out.println(deleteCount);

    }
}
