package com.example.Week22.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="department")
public class Department {
    @Id
    private String departmentId;
    private String dept_name;
    private String description;

    public Department(String departmentId, String dept_name, String description, List<Employee> employees) {
        this.departmentId = departmentId;
        this.dept_name = dept_name;
        this.description = description;
        this.employees = employees;
    }

    public Department(String departmentId, String dept_name, String description) {
        this.departmentId = departmentId;
        this.dept_name = dept_name;
        this.description = description;
    }

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Employee> employees;


}
