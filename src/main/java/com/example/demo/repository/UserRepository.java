package com.example.demo.repository;

import com.example.demo.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(int id);

    List<User> findById();

    User findById(String user_id);

    User save(User user);
    void delete(User user);

    void deleteById(String user_id);

    void update(User user);

    User findByUsernameAndPassword(String username, String password); // Tìm người dùng theo username và password

    User findByUserId(String user_id); // Phương thức để tìm user theo user_id
}
