package com.example.demo.controller;

import com.example.demo.repository.ShoeRepositoryImpl;
import com.example.demo.entity.Shoe;
import com.example.demo.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoes")
public class ShoeController {
    @Autowired
    private ShoeService shoeService;
    @Autowired
    private ShoeRepositoryImpl shoeJdbcRepositoryImpl;

    @GetMapping
    public List<Shoe> getAllShoes() {
        return shoeService.getAllShoes();
    }

    @GetMapping("/{id}")
    public Shoe getShoeById(@PathVariable String id) {
        return shoeService.getShoeById(id);
    }

    @PostMapping
    public Shoe createShoe(@RequestBody Shoe shoe) {
        return shoeJdbcRepositoryImpl.save(shoe); // Lưu vào cơ sở dữ liệu
    }
    @PutMapping("/{id}")
    public ResponseEntity<Shoe> updateShoe(@PathVariable String id, @RequestBody Shoe shoe) {
        shoe.setId(id);
        shoeJdbcRepositoryImpl.update(shoe);
        return ResponseEntity.ok(shoe);
    }
    @DeleteMapping("/{id}")
    public void deleteShoe(@PathVariable String id) {
        shoeService.deleteShoe(id);
    }
    @GetMapping("/search")
    public List<Shoe> searchShoes(@RequestParam String keyword) {
        return shoeService.searchShoesByKeyword(keyword);
    }
}
