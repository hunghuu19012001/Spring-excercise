package com.example.logging.service.impl;

import com.example.logging.dto.EmployeeDTO;
import com.example.logging.service.EmployeeDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDTOServiceimpl implements EmployeeDTOService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDTOServiceimpl.class);

    public EmployeeDTO getEmployeeDTO(EmployeeDTO employeeDTO){
        LOGGER.info("Employee : {} ",employeeDTO);
        return employeeDTO;
    }
}
