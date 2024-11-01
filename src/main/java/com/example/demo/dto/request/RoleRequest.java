package com.example.demo.dto.request;

import lombok.Getter;

import java.util.List;

public class RoleRequest {
    @Getter
    private String roleId;
    private String roleName;
    private List<String> permissions;

    public String getRoleName() {
    }
}
