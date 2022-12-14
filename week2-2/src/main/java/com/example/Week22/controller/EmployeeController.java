package com.example.Week22.controller;

import com.example.Week22.entity.Employee;
import com.example.Week22.entity.ResponseObject;
import com.example.Week22.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "insert")
    public ResponseEntity<ResponseObject>  insertEmployee(@RequestBody Employee employee){
        return employeeService.insertEmployee(employee);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody Employee newEmployee,
                                                         @PathVariable Long id){
        return employeeService.updateEmployee(newEmployee, id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseObject> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("findAll")
    public ResponseEntity<ResponseObject> findAll(){
        return employeeService.findAll();
    }

}


