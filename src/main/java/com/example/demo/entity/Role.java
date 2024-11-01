package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private String roleId;
    private String roleName;

    public Role() {}

    public Role(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role orElseThrow(Object roleKhôngTồnTại) {
        return new Role(roleId, roleName);
    }

    public Collection<Object> getPermissions() {
    }
}
