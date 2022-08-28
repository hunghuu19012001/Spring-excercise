package com.example.Week22.service.impl;

import com.example.Week22.entity.Department;
import com.example.Week22.entity.ResponseObject;
import com.example.Week22.repository.DepartmentRepository;
import com.example.Week22.repository.MBRepository;
import com.example.Week22.service.DepartmentService;
import com.example.Week22.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;

    private final MBRepository mbRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeService employeeService, MBRepository mbRepository){
        this.departmentRepository = departmentRepository;
        this.employeeService = employeeService;
        this.mbRepository = mbRepository;
    }

    @Override
    public ResponseEntity<ResponseObject> autoCreteDepartments(){
        List<Department> departments = Arrays.asList(
                new Department("001", "Supervisorship", "supervisorship"),
                new Department("OO2", "President", "President"),
                new Department("OO3", "Director", "Director")
        );
        departments.forEach(departmentRepository::save);
        return ResponseEntity.ok().body(new ResponseObject("ok","data about department inserted",
                departments));
    }

    @Override
    public ResponseEntity<ResponseObject> autoCreateDepartments() {
        List<Department> departments = Arrays.asList(
                new Department("001", "Supervisorship", "Supervisorship"),
                new Department("OO2", "President", "President"),
                new Department("OO3", "Director", "Director")
        );
        departments.forEach(departmentRepository::save);
        return ResponseEntity.ok().body(new ResponseObject("ok",
                "data about department inserted",
                departments
        ));
    }

    @Override
    public ResponseEntity<ResponseObject> updateDepartment(Department newDepartment, String id){
        Department updateDepartment = departmentRepository.findById(id)
                .map(department ->{
                    department.setDepartmentId(newDepartment.getDepartmentId());
                    department.setDept_name(newDepartment.getDept_name());
                    department.setDescription(newDepartment.getDescription());
                    department.setEmployees(newDepartment.getEmployees());
                    return departmentRepository.save(department);
                }).orElseGet(()->{
                    newDepartment.setDepartmentId(id);
                    return departmentRepository.save(newDepartment);
                });
                return ResponseEntity.ok().body(
                        new ResponseObject("ok","update seccesfully", updateDepartment)
                );
    }
    @Override
    public ResponseEntity<ResponseObject> deleteDepartmentById(String id){
        boolean exits = departmentRepository.existsById(id);
        if(exits){
            employeeService.deleteByDepartmentId(id);
            departmentRepository.deleteById(id);
            return ResponseEntity.ok().body(new ResponseObject(
                    "ok",
                    "delete successfully",
                    ""
            ));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                    "fail", "departmentId not exits", ""
            ));


        }
    }
    @Override
    public ResponseEntity<ResponseObject> findById(String id){
        Optional<Department> foundDepartment = departmentRepository.findById(id);
        return foundDepartment.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                        "ok", "successfully", foundDepartment)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                        "fail", "not found", "")
                );
    }
}

