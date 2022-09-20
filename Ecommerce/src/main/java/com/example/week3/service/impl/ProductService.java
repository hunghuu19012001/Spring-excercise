package com.example.week3.service.impl;

import com.example.week3.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> findProductLessThan(BigDecimal price);
    List<Product> findProductGreaterThan(BigDecimal price);
    List<Product> findProductEqual(BigDecimal price);
}

