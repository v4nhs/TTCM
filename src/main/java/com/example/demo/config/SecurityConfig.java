package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Chỉ cho phép ADMIN truy cập
                        .requestMatchers("/customer/**").hasRole("CUSTOMER")  // Chỉ cho phép CUSTOMER truy cập
                        .anyRequest().authenticated() // Các request khác yêu cầu phải đăng nhập
                )
                .formLogin(withDefaults())  // Cấu hình form login mặc định
                .logout(withDefaults());    // Cấu hình logout mặc định
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Sử dụng mã hóa mật khẩu
    }
}
