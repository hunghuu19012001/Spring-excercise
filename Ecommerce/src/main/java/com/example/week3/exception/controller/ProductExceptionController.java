package com.example.week3.exception.controller;

import com.example.week3.exception.ProductNotFoundException;
import com.example.week3.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ResponseObject> exception (ProductNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Error",
                "nameProduct not exist",
                exception.getCause()
        ));
    }
}
