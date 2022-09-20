package com.example.week3.exception.controller;

import com.example.week3.exception.NotEnoughItemException;
import com.example.week3.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartItemExceptionController {
    @ExceptionHandler(value = NotEnoughItemException.class)
    public ResponseEntity<ResponseObject> exception (NotEnoughItemException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject(
                "Fail",
                "Not enough item",
                exception.getCartItemList()
        ));
    }
}
