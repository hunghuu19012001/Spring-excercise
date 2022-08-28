package com.example.Week22.service;

import com.example.Week22.entity.Employee;
import com.example.Week22.entity.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<ResponseObject> insertEmployee(Employee employee);

    ResponseEntity<ResponseObject> updateEmployee(Employee newEmployee, Long id);

    ResponseEntity<ResponseObject> deleteEmployee(Long id);

    ResponseEntity<ResponseObject> findAll();

    void deleteByDepartmentId(String id);
}
