package com.likelion.threetier.controller;

import com.likelion.threetier.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping

public class DemoController {
    @Autowired
    DemoServiceImpl demoService;
    @GetMapping("/fun1")
    public String returnTemplate(ModelMap modelMap){
        modelMap.addAttribute("listObject", demoService.listElements());
        return "text";
    }
    @GetMapping("/fun2/{id}")
    @ResponseBody
    public Object returnJson(@PathVariable String id){
        return demoService.elementById(id);
    }
}
