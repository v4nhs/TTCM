package com.example.demo.repository;

import com.example.demo.entity.Shoe;

import java.util.List;

public interface ShoeRepository {
    List<Shoe> findAll();
    Shoe findById(String id);
    Shoe save(Shoe shoe);
    void deleteById(String id);

    void update(Shoe shoe);
}
