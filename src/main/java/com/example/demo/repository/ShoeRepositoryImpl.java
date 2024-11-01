package com.example.demo.repository;

import com.example.demo.entity.Shoe;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ShoeRepositoryImpl implements ShoeRepository {
    private final JdbcTemplate jdbcTemplate;

    public ShoeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Shoe> findAll() {
        String sql = "SELECT * FROM shoes";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Shoe shoe = new Shoe();
            shoe.setId(rs.getString("id"));
            shoe.setImage(rs.getString("image"));
            shoe.setName(rs.getString("name"));
            shoe.setKeyword(rs.getString("keyword"));
            shoe.setPrice(rs.getDouble("price"));
            return shoe;
        });
    }

    @Override
    public Shoe findById(String id) {
        String sql = "SELECT * FROM shoes WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                Shoe shoe = new Shoe();
                shoe.setId(rs.getString("id"));
                shoe.setImage(rs.getString("image"));
                shoe.setName(rs.getString("name"));
                shoe.setKeyword(rs.getString("keyword"));
                shoe.setPrice(rs.getDouble("price"));
                return shoe;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Hoặc ném ra một ngoại lệ tùy chỉnh
        }
    }

    @Override
    public Shoe save(Shoe shoe) {
        if (shoe.getId() == null || shoe.getId().isEmpty()) {
            shoe.setId(UUID.randomUUID().toString()); // Tạo ID mới
        }
        String sql = "INSERT INTO shoes (id, image, name, keyword, price, description) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, shoe.getId(), shoe.getImage(), shoe.getName(), shoe.getKeyword(), shoe.getPrice(), shoe.getDescription());
        return shoe;
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM shoes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Shoe shoe) {
        String sql = "UPDATE shoes SET image = ?, name = ?, keyword = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, shoe.getImage(), shoe.getName(), shoe.getKeyword(), shoe.getPrice(), shoe.getId());
    }
}
