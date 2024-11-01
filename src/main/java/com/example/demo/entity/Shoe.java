package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shoes")
public class Shoe {
    @Id
    private String id;
    private String image;
    private String name;
    private String keyword;
    private double price;
    private String description; // Thêm trường description

    // Constructor với tất cả các trường
    public Shoe(String id, String image, String name, String keyword, double price, String description) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.keyword = keyword;
        this.price = price;
        this.description = description;
    }

    public Shoe() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getKeyword() {
        return keyword;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
