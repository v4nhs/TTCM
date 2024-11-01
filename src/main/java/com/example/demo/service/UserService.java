package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private List<User> getAllUsers(){
        return userRepository.findAll();
    };
    public User getAllById(String user_id){
        return userRepository.findById(user_id);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void delete(String user_id){
        if(userRepository.findById(user_id) != null){
            userRepository.deleteById(user_id);
        }else {
            throw new RuntimeException("Không tìm thấy tài khoản người dùng với ID"+ user_id);
        }
    }


    public User findByUserId(String user_id) {
        return userRepository.findByUserId(user_id); // Tìm kiếm theo user_id
    }
}
