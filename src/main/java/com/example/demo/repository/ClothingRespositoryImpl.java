package com.example.demo.repository;

import com.example.demo.entity.Clothing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class ClothingRepositoryImpl implements ClothingRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClothingRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Clothing> findAll() {
        String sql = "SELECT * FROM clothing"; // Câu lệnh SQL để lấy tất cả clothing
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Clothing clothing = new Clothing();
            clothing.setId(rs.getString("id"));
            clothing.setName(rs.getString("name"));
            clothing.setImage(rs.getString("image"));
            clothing.setKeyword(rs.getString("keyword"));
            clothing.setPrice(rs.getDouble("price"));
            clothing.setDescription(rs.getString("description"));
            return clothing;
        });
    }

    @Override
    public Clothing findById(String id) {
        String sql = "SELECT * FROM clothing WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Clothing clothing = new Clothing();
            clothing.setId(rs.getString("id"));
            clothing.setName(rs.getString("name"));
            clothing.setImage(rs.getString("image"));
            clothing.setKeyword(rs.getString("keyword"));
            clothing.setPrice(rs.getDouble("price"));
            clothing.setDescription(rs.getString("description"));
            return clothing;
        });
    }

    @Override
    public Clothing save(Clothing clothing) {
        String sql = "INSERT INTO clothing (id, name, image, keyword, price, description) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, clothing.getId(), clothing.getName(), clothing.getImage(), clothing.getKeyword(), clothing.getPrice(), clothing.getDescription());
        return clothing;
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM clothing WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public void update(Clothing clothing) {
        String sql = "UPDATE clothing SET image = ?, name = ?, keyword = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, clothing.getImage(), clothing.getName(), clothing.getKeyword(), clothing.getPrice(), clothing.getId());
    }
}
