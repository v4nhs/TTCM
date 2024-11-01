package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setUser_id(rs.getString("user_id"));
            user.setEmail(rs.getString("email"));
            user.setUser_name(rs.getString("user_name"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }

    @Override
    public User findById(int id) {
        return null; // Phương thức này có thể bỏ đi nếu không cần thiết
    }

    @Override
    public List<User> findById() {
        return List.of(); // Phương thức này có thể bỏ đi nếu không cần thiết
    }

    @Override
    public User findById(String user_id) {
        String sql = "SELECT * FROM users WHERE user_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{user_id}, (rs, rowNum) -> {
                User user = new User();
                user.setUser_id(rs.getString("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUser_name(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                return user;
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User save(User user) {
        if (user.getUser_id() == null || user.getUser_id().isEmpty()) {
            user.setUser_id(UUID.randomUUID().toString());
        }
        String sql = "INSERT INTO users (user_id, email, user_name, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUser_id(), user.getEmail(), user.getUser_name(), user.getPassword());
        return user;
    }

    @Override
    public void delete(User user) {
        // Bạn có thể thêm logic để xóa người dùng nếu cần
    }

    @Override
    public void deleteById(String user_id) {
        String sql = "DELETE FROM users WHERE user_id=?";
        jdbcTemplate.update(sql, user_id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET user_name=?, password=? WHERE user_id=?";
        jdbcTemplate.update(sql, user.getUser_name(), user.getPassword(), user.getUser_id());
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE user_name=? AND password=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username, password}, (rs, rowNum) -> {
                User user = new User();
                user.setUser_id(rs.getString("user_id"));
                user.setEmail(rs.getString("email"));
                user.setUser_name(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                return user;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Không tìm thấy người dùng
        }
    }

    @Override
    public User findByUserId(String user_id) {
        return null;
    }
}
