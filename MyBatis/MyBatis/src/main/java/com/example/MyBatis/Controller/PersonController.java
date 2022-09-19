package com.example.MyBatis.Controller;

import com.example.MyBatis.Entity.Person;
import com.example.MyBatis.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/mybatis")
public class PersonController {
    private PersonService personService;

    @PostMapping("")
    public ResponseEntity<Person> insert(@RequestBody Person person){
        personService.insert(person);
        return ResponseEntity.ok().body(person);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<Optional<Person>> findAll(@PathVariable Long id){
        Optional<Person> person = personService.findById(id);
        return ResponseEntity.ok().body(person);
    }
}

