package com.example.MyBatis.Entity;

import ch.qos.logback.core.joran.action.Action;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private Long id;
    private String fullName;
    private Date dateOfBirth;


}
