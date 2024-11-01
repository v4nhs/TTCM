package com.example.demo.service;

import com.example.demo.repository.ClothingRepository;
import com.example.demo.entity.Clothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothingService {

    @Autowired
    private ClothingRepository clothingRepository;

    public List<Clothing> getAllClothing() {
        return clothingRepository.findAll();
    }

    public Clothing getClothingById(String id) {
        Clothing clothing = clothingRepository.findById(id);
        if (clothing == null) {
            throw new ResourceAccessException("Clothing not found with id: " + id);
        }
        return clothing;
    }

    public void createClothing(Clothing clothing) {
        clothingRepository.save(clothing);
    }

    public void deleteClothing(String id) {
        clothingRepository.deleteById(id);
    }

    public List<Clothing> searchClothingByKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getAllClothing();
        }
        return clothingRepository.findAll().stream()
                .filter(clothing -> {
                    String clothingName = clothing.getName();
                    String clothingDescription = (String) clothing.getDescription();

                    boolean matchesName = clothingName != null && clothingName.toLowerCase().contains(keyword.toLowerCase());
                    boolean matchesDescription = clothingDescription != null && clothingDescription.toLowerCase().contains(keyword.toLowerCase());

                    return matchesName || matchesDescription;
                })
                .collect(Collectors.toList());
    }
}
