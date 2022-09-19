package com.example.week3.entity;


import com.example.week3.entity.CartItem;
import com.example.week3.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "cart")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    List<CartItem> cartItems;
}
