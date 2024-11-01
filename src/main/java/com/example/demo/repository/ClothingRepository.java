package com.example.demo.repository;

import com.example.demo.entity.Clothing;

import java.util.List;

public interface ClothingRepository {
    List<Clothing> findAll();
    Clothing findById(String id);
    Clothing save(Clothing clothing);
    void deleteById(String id);

    void update(Clothing clothing);
}
