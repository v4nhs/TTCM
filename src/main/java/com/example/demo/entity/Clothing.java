package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clothing")
public class Clothing {
    @Id
    private String id;
    private String image;
    private String name;
    private String keyword;
    private double price;
    private String description;

    public Clothing(String id, String image, String name, String keyword, double price, String description) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.keyword = keyword;
        this.price = price;
        this.description = description;
    }

    public Clothing() {
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

    public String setDescription(String description) {
        return description;
    }

    public String getDescription() {
        return description;
    }
}
