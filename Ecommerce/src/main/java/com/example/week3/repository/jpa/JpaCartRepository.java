package com.example.week3.repository.jpa;

import com.example.week3.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCartRepository extends JpaRepository<Cart,Long> {
}
