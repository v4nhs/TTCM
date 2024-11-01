package com.example.demo.controller;

import com.example.demo.repository.ClothingRepository;
import com.example.demo.entity.Clothing;
import com.example.demo.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothing")
public class ClothingController {

    @Autowired
    private ClothingService clothingService;

    @Autowired
    private ClothingRepository clothingRepository; // Sử dụng đúng tên biến

    @GetMapping
    public List<Clothing> getAllClothing() {
        return clothingService.getAllClothing();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clothing> getClothingById(@PathVariable String id) {
        Clothing clothing = clothingService.getClothingById(id);
        return ResponseEntity.ok(clothing);
    }

    @PostMapping
    public Clothing createClothing(@RequestBody Clothing clothing) {
        return clothingRepository.save(clothing); // Lưu vào cơ sở dữ liệu
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clothing> updateClothing(@PathVariable String id, @RequestBody Clothing clothing) {
        clothing.setId(id);
        clothingRepository.update(clothing);
        return ResponseEntity.ok(clothing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothing(@PathVariable String id) {
        clothingService.deleteClothing(id);
        return ResponseEntity.noContent().build(); // Trả về 204 No Content
    }

    @GetMapping("/search")
    public List<Clothing> searchClothing(@RequestParam String keyword) {
        return clothingService.searchClothingByKeyword(keyword);
    }
}
