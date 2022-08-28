package com.example.Week22.service.impl;

import com.example.Week22.entity.Department;
import com.example.Week22.entity.Employee;
import com.example.Week22.entity.ResponseObject;
import com.example.Week22.entity.dto.Employeedto;
import com.example.Week22.repository.DepartmentRepository;
import com.example.Week22.repository.EmployeeRepository;
import com.example.Week22.repository.MBRepository;
import com.example.Week22.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final MBRepository mbRepository;


    public EmployeeServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, MBRepository mbRepository){
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.mbRepository = mbRepository;
    }
    @Override
    public ResponseEntity<ResponseObject> insertEmployee(Employee employee) {
        try{
            if(departmentRepository.findById(employee.getDepartmentId()).isPresent()){
                Department departmentOfEmployee = departmentRepository.findById(employee.getDepartmentId()).orElse(null);
                Employee newEmployee = new Employee(
                        employee.getName(),
                        employee.getBirthDate(),
                        employee.getGender(),
                        employee.getDepartmentId(),
                        departmentOfEmployee
                );
                employeeRepository.save(newEmployee);
                Employeedto employeeDTO = new Employeedto(newEmployee.getEmployeeId(),
                        newEmployee.getName(),
                        newEmployee.getBirthDate(),
                        newEmployee.getGender(),
                        newEmployee.getDepartmentId());
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "create successfully",employeeDTO)
                );
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("fail","Id exits",null)
                );
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject("fail","error",null)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateEmployee(Employee newEmployee, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> deleteEmployee(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> findAll() {
        return null;
    }

    @Override
    public void deleteByDepartmentId(String id) {

    }
}
