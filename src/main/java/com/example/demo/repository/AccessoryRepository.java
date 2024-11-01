package com.example.demo.repository;

import com.example.demo.entity.Accessory;
import java.util.List;

public interface AccessoryRepository {
    List<Accessory> findAll();
    Accessory findById(String id);
    Accessory save(Accessory accessory);
    void deleteById(String id);

    void update(Accessory accessory);
}