package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @RequestMapping(value = "/naver", method = RequestMethod.GET)
    public String naverPage() {return "Naver";}
    @GetMapping(value = "/likelion")
    public String likelionPage() {return "LikeLion";}
}
