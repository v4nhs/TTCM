package com.example.demo.service;

import com.example.demo.repository.ShoeRepository;
import com.example.demo.entity.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    public List<Shoe> getAllShoes() {
        return shoeRepository.findAll();
    }

    public Shoe getShoeById(String id) {
        return shoeRepository.findById(id);
    }

    public void deleteShoe(String id) {
        if (shoeRepository.findById(id) != null) {
            shoeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Không tìm thấy sản phẩm với ID: " + id);
        }
    }

    public List<Shoe> searchShoesByKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getAllShoes();
        }
        return shoeRepository.findAll().stream()
                .filter(shoe -> shoe.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        (shoe.getDescription() != null && shoe.getDescription().toLowerCase().contains(keyword.toLowerCase())))
                .collect(Collectors.toList());
    }
}
