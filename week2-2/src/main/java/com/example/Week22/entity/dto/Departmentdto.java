package com.example.Week22.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departmentdto {

    private String departmentId;
    private String dept_name;
    private String description;
    private Integer numEmployee;
}
