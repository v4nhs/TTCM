package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class RoleRepositoryImpl implements RoleRepository {
    private final JdbcTemplate jdbcTemplate;
    public RoleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        String sql = "select * from roles";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Role role = new Role();
            role.setRole_id(rs.getString("role_id"));
            role.setRole_name(rs.getString("role_name"));
            return role;
        });
    }
}
