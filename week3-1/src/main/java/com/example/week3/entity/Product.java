package com.example.week3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name_product", nullable = false, length = 100)
    private String name;

    @Column(length = 3)
    private String type;

    @Column(length = 3)
    private String size;

    @Column(nullable = false)
    private Double price;
}
