package com.example.week3.exception.controller;

import com.example.week3.exception.CustomerNotFoundException;
import com.example.week3.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionController {
    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<ResponseObject> exception (CustomerNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Error",
                "customerId not exist",
                exception.getMessage()
        ));
    }
}
