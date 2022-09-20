package com.example.week3.exception;

import com.example.week3.model.CartItem;
import lombok.Data;

import java.util.List;

@Data
public class NotEnoughItemException extends RuntimeException{
    private final List<CartItem> cartItemList;

    public NotEnoughItemException(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

}
