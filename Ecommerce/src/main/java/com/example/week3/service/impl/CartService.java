package com.example.week3.service.impl;

import com.example.week3.dto.ItemDTO;

import java.util.List;

public interface CartService {
    List<ItemDTO> insertItem(Long customerId, List<ItemDTO> itemList);
}
