package com.example.MyBatis.Service.Impl;

import com.example.MyBatis.Entity.Person;
import com.example.MyBatis.Service.PersonService;
import com.example.MyBatis.repository.PersonRopository;

import javax.annotation.Resource;
import java.util.Optional;

public class PersonServiceImpl implements PersonService {
    @Resource
    PersonRopository personRopository;

    @Override
    public void insert(Person person) {
        personRopository.insert(person);
    }

    @Override
    public int countPerson(){
        return personRopository.count();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.empty();
    }
}
