package com.example.jdbcpractice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Role {
    private Integer roleId;
    private String description;

    public Role(Integer roleId, String description) {
        this.roleId = roleId;
        this.description = description;
    }
}
