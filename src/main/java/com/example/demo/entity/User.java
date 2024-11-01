package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    private String user_id;
    private String user_name;
    private String password;
    private String email;

    // Thêm setter cho role
    // Thêm getter cho role
    @ManyToOne
    private Role role; // Thêm thuộc tính role

    public User() {
        super();
    }

    public User(String user_id, String user_name, String password, String email, Role role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.role = role; // Khởi tạo role
    }

}
