package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Đã thay đổi từ "accounts" thành "users"
public class User {
    @Id
    private String userId;

    private String username;
    private String password;

    @Column(unique = true)
    private String email;

    private String roleId;
    private String roleName; // Thêm trường này để chứa tên vai trò

    public User() {}

    public User(String userId, String username, String password, String email, String roleId, String roleName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
        this.roleName = roleName; // Cập nhật constructor
    }

    // Getters và Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRoleId() { return roleId; }
    public void setRoleId(String roleId) { this.roleId = roleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; } // Thêm getter và setter cho roleName

    public User orElseThrow(Object ngườiDùngKhôngTồnTại) {
        return username.equals(username) ? this : null;
    }
}
