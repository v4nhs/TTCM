package com.example.demo.service;

import com.example.demo.repository.AccessoryRepository;
import com.example.demo.entity.Accessory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    public List<Accessory> getAllAccessory() {
        return accessoryRepository.findAll();
    }

    public Accessory getAccessoryById(String id) {
        return accessoryRepository.findById(id);
    }

    // Phương thức này là phương thức tạo sản phẩm
    public void createAccessory(Accessory accessory) {
        try {
            accessoryRepository.save(accessory);
        } catch (DuplicateKeyException e) {
            // Xử lý lỗi khi sản phẩm đã tồn tại
            throw new RuntimeException("Sản phẩm với ID " + accessory.getId() + " đã tồn tại.", e);
        }
    }

    public void deleteAccessory(String id) {
        accessoryRepository.deleteById(id);
    }

    public List<Accessory> searchAccessoriesByKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return getAllAccessory();
        }
        return accessoryRepository.findAll().stream()
                .filter(accessory -> accessory.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        (accessory.getDescription() != null && accessory.getDescription().toLowerCase().contains(keyword.toLowerCase())))
                .collect(Collectors.toList());
    }

    public Accessory updateAccessory(String id, Accessory accessory) {
        // Kiểm tra xem sản phẩm có tồn tại hay không
        Accessory existingAccessory = accessoryRepository.findById(id);
        if (existingAccessory == null) {
            throw new RuntimeException("Sản phẩm không tồn tại");
        }

        // Cập nhật các trường thông tin
        existingAccessory.setImage(accessory.getImage());
        existingAccessory.setName(accessory.getName());
        existingAccessory.setKeyword(accessory.getKeyword());
        existingAccessory.setPrice(accessory.getPrice());

        return accessoryRepository.save(existingAccessory);
    }
}
