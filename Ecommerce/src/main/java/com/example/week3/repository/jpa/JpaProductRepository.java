package com.example.week3.repository.jpa;

import com.example.week3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameProduct(String productName);
}
