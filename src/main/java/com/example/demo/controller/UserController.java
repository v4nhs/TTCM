package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRepositoryImpl;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{user_id}")
    public User getUser(@PathVariable String user_id) {
        return userRepository.findById(user_id);
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PutMapping("/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable String user_id, @RequestBody User user) {
        user.setUser_id(user_id);
        userRepositoryImpl.update(user);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable String user_id) {
        userService.delete(user_id);
    }

}
