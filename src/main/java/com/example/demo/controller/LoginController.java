package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository; // Import UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserRepository userRepository; // Khai báo UserRepository

    @Autowired // Sử dụng @Autowired để tự động inject UserRepository
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Trả về file login.html
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        User user = userRepository.findByUsernameAndPassword(username, password); // Gọi đến phương thức tìm kiếm người dùng
        if (user != null) {
            return "redirect:/home"; // Chuyển đến trang chủ nếu đăng nhập thành công
        } else {
            model.addAttribute("error", "Invalid username or password"); // Thêm thông báo lỗi vào model
            return "login"; // Trả về trang đăng nhập nếu thất bại
        }
    }

}
