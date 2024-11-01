package com.example.demo.repository;

import com.example.demo.entity.Role;

import java.util.List;

public interface RoleRepository {
    List<Role> findAll();
    Role findById(int id);
    Role save(Role role);
    void delete(Role role);
    void update(Role role);
}
