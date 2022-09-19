package com.like.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/customer")
public class DriverController {

    @GetMapping("/Taxi")
    public String getTaxi(){
        return "You found a taxi";
    }
}
