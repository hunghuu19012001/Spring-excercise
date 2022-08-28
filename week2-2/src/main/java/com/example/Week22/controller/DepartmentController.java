package com.example.Week22.controller;

import com.example.Week22.entity.Department;
import com.example.Week22.entity.ResponseObject;
import com.example.Week22.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("department")
public class DepartmentController {
    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping(value = "createDepartments")
    public ResponseEntity<ResponseObject> autoCreateDepartments(){
        return departmentService.autoCreateDepartments();
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseObject> updateDepartment(@RequestBody Department newDepartment,
                                                           @PathVariable String id){
        return departmentService.updateDepartment(newDepartment, id);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseObject> deteleDepartment(@PathVariable String id){
        return departmentService.deleteDepartmentById(id);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable String id){

        return departmentService.findById(id);
    }

}
