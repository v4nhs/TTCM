package com.example.demo.controller;

import com.example.demo.entity.Accessory;
import com.example.demo.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accessories")
public class AccessoryController {
    @Autowired
    private AccessoryService accessoryService;

    @GetMapping
    public List<Accessory> getAllAccessory() {
        return accessoryService.getAllAccessory();
    }

    @GetMapping("/{id}")
    public Accessory getAccessoryById(@PathVariable String id) {
        return accessoryService.getAccessoryById(id);
    }

    @PostMapping
    public void createAccessory(@RequestBody Accessory accessory) {
        accessoryService.createAccessory(accessory);
    }

    @DeleteMapping("/{id}")
    public void deleteAccessory(@PathVariable String id) {
        accessoryService.deleteAccessory(id);
    }

    @GetMapping("/search")
    public List<Accessory> searchAccessories(@RequestParam String keyword) {
        return accessoryService.searchAccessoriesByKeyword(keyword);
    }

    @PutMapping("/api/accessories/{id}")
    public ResponseEntity<Accessory> updateAccessory(@PathVariable String id, @RequestBody Accessory accessory) {
        try {
            Accessory updatedAccessory = accessoryService.updateAccessory(id, accessory);
            return ResponseEntity.ok(updatedAccessory);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
