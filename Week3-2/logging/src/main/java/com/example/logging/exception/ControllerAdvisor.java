package com.example.logging.exception;

import com.example.logging.reponse.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
    @ExceptionHandler(value = ArgumentNotValidException.class)
    public ResponseEntity<ResponseObject> handleArgumentNotValidException(ArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject(
                "Fail",
                "Argument Not Valid !!",
                errorMap
        ));
    }
}
