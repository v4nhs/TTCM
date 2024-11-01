package com.example.demo.repository;

import com.example.demo.entity.Accessory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccessoryRepositoryImpl implements AccessoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public AccessoryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Accessory> findAll() {
        String sql = "SELECT * FROM accessories";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Accessory accessory = new Accessory();
            accessory.setId(rs.getString("id"));
            accessory.setImage(rs.getString("image"));
            accessory.setName(rs.getString("name"));
            accessory.setKeyword(rs.getString("keyword"));
            accessory.setPrice(rs.getDouble("price"));
            return accessory;
        });
    }

    @Override
    public Accessory findById(String id) {
        String sql = "SELECT * FROM accessories WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Accessory accessory = new Accessory();
            accessory.setId(rs.getString("id"));
            accessory.setImage(rs.getString("image"));
            accessory.setName(rs.getString("name"));
            accessory.setKeyword(rs.getString("keyword"));
            accessory.setPrice(rs.getDouble("price"));
            return accessory;
        });
    }

    @Override
    public Accessory save(Accessory accessory) {
        String sql = "INSERT INTO accessories (id, image, name, keyword, price) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, accessory.getId(), accessory.getImage(), accessory.getName(), accessory.getKeyword(), accessory.getPrice());
        return accessory; // Trả về đối tượng accessory sau khi lưu
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM accessories WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Accessory accessory) {
        String sql = "UPDATE accessories SET image = ?, name = ?, keyword = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, accessory.getImage(), accessory.getName(), accessory.getKeyword(), accessory.getPrice(), accessory.getId());
    }
}
