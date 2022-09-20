package com.example.week3.service.impl;

import com.example.week3.model.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> findByCondition(Long customerId,
                                   String nameProduct,
                                   Integer offset,
                                   Integer limit);
}
