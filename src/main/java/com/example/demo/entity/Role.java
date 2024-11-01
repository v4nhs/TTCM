package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    private String role_id;
    private String role_name;

    // Định nghĩa mối quan hệ với User
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public Role() {
    }

    public Role(String role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

}
