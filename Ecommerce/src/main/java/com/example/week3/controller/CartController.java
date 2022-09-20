package com.example.week3.controller;

import com.example.week3.dto.ItemDTO;
import com.example.week3.model.CartItem;
import com.example.week3.model.ResponseObject;
import com.example.week3.service.impl.CartItemService;
import com.example.week3.service.impl.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
    private final CartService cartService;
    private final CartItemService cartItemService;
    public CartController(CartService cartService, CartItemService cartItemService) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
    }

    @PostMapping("insertProduct/{customerId}")
    public ResponseEntity<ResponseObject> insertItem(@PathVariable Long customerId,
                                                     @RequestBody List<ItemDTO> itemList){
        cartService.insertItem(customerId,itemList);
        return ResponseEntity.ok().body(new ResponseObject(
                "Ok",
                "Successfully",
                itemList
        ));
    }

    @GetMapping("getCartItem")
    public ResponseEntity<ResponseObject> getCartItem(@RequestParam Long customerId,
                                                      @RequestParam String nameProduct,
                                                      @RequestParam Integer offset,
                                                      @RequestParam Integer limit){
        List<CartItem> lisItem = cartItemService
                .findByCondition(customerId, nameProduct, offset, limit);

        return ResponseEntity.ok().body(new ResponseObject(
                "OK",
                "Successfully",
                lisItem
        ));
    }
}
