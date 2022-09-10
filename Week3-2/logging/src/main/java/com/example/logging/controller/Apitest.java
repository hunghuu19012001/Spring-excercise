package com.example.logging.controller;


import com.example.logging.dto.DepartmentDTO;
import com.example.logging.dto.EmployeeDTO;
import com.example.logging.exception.ArgumentNotValidException;
import com.example.logging.reponse.ResponseObject;
import com.example.logging.service.DepartmentDTOService;
import com.example.logging.service.EmployeeDTOService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.Map;

@RequestMapping("")
@RestController
public class Apitest {
    private final DepartmentDTOService departmentDTOService;
    private final EmployeeDTOService employeeDTOService;

    public Apitest(DepartmentDTOService departmentDTOService, EmployeeDTOService employeeDTOService) {
        this.departmentDTOService = departmentDTOService;
        this.employeeDTOService = employeeDTOService;
    }


    @PostMapping("department")
    public ResponseEntity<ResponseObject> addDepartment(@RequestBody @Valid DepartmentDTO departmentDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ArgumentNotValidException(bindingResult);
        }
        departmentDTOService.getDepartmentDTO(departmentDTO);
        return ResponseEntity.ok().body(new ResponseObject(
                "ok",
                "Successfully",
                (Map<String, String>) departmentDTO));
    }
    @PostMapping("employee")
    public ResponseEntity<Object> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ArgumentNotValidException(bindingResult);
        }
        employeeDTOService.getEmployeeDTO(employeeDTO);
        return ResponseEntity.ok().body(new ResponseObject(
                "ok",
                "Successfully",
                (Map<String, String>) employeeDTO
        ));
    }


}
