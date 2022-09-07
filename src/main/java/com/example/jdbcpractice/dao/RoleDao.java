package com.example.jdbcpractice.dao;

import com.example.jdbcpractice.dto.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {

    private static String dbUrl = "jdbc:mysql://localhost:3306/connectdb";
    private static String dbUser = "connectuser";
    private static String dbPassword = "connect123!@#";

    // 1. select
    public Role getRole(Integer roleId) {
        Role role = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1. 드라이버 로딩하기
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select role_id, description from role where role_id = ?"; // 쿼리 만들기

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword); // 2. connection 객체 얻기
             PreparedStatement ps = conn.prepareStatement(sql)) { // 3. statement 객체 얻기
            ps.setInt(1, roleId);

            try (ResultSet rs = ps.executeQuery()) { // 4. statement 객체 실행 & resultSet 객체 얻기
                if (rs.next()) {
                    String description = rs.getString(1);
                    int id = rs.getInt("role_id");
                    role = new Role(id, description);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }

    // 2. update
    public int updateRole(Role role) {
        int insertCount = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1. 드라이버 로딩하기
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "insert into role (role_id, description) values (?,?)"; // 쿼리 만들기

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword); // 2. connection 객체 얻기
                PreparedStatement ps = conn.prepareStatement(sql)) { // 3. statement 객체 얻기
            ps.setInt(1, role.getRoleId());
            ps.setString(2, role.getDescription());

            insertCount = ps.executeUpdate();// 4. statement 객체 실행


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return insertCount;
    }

    // 3. delete
    public int deleteRole(int roleId) {
        int deleteCount = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1. 드라이버 로딩하기
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "delete from role where role_id = ?"; // 쿼리 만들기

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword); // 2. connection 객체 얻기
             PreparedStatement ps = conn.prepareStatement(sql)) { // 3. statement 객체 얻기
            ps.setInt(1, roleId);

            deleteCount = ps.executeUpdate();// 4. statement 객체 실행


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return deleteCount;
    }

    // 4. selectAll
    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1. 드라이버 로딩하기
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "select role_id, description from role order by role_id desc"; // 쿼리 만들기

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword); // 2. connection 객체 얻기
             PreparedStatement ps = conn.prepareStatement(sql)) { // 3. statement 객체 얻기

            try (ResultSet rs = ps.executeQuery()) {// 4. statement 객체 실행

                while (rs.next()) {
                    int id = rs.getInt("role_id");
                    String description = rs.getString("description");

                    Role role = new Role(id, description);
                    list.add(role);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

}
