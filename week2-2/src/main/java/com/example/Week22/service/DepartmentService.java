package com.example.Week22.service;

import com.example.Week22.entity.Department;
import com.example.Week22.entity.ResponseObject;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {
    ResponseEntity<ResponseObject> autoCreateDepartments();

    ResponseEntity<ResponseObject> updateDepartment(Department newDepartment, String id);

    ResponseEntity<ResponseObject> deleteDepartmentById(String id);

    ResponseEntity<ResponseObject> findById(String id);

    ResponseEntity<ResponseObject> autoCreteDepartments();
}
