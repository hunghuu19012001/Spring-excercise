package com.example.Week22.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Employeedto {
    private String name;
    private Date birthDate;
    private Boolean gender;
    private Departmentdto department;

    public Employeedto(Long employeeId, String name, Date birthDate, Boolean gender, String departmentId) {
    }
}
