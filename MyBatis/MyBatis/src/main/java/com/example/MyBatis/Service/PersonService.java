package com.example.MyBatis.Service;

import com.example.MyBatis.Entity.Person;
import org.apache.ibatis.annotations.Insert;

import java.util.Optional;

public interface PersonService {
    static void Person(Person person) {
    }
    public void insert(Person person);

    int countPerson();

    Optional<Person> findById(Long id);
}
