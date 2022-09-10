package com.example.logging.service.impl;

import com.example.logging.dto.DepartmentDTO;
import com.example.logging.service.DepartmentDTOService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDTOServiceimpl implements DepartmentDTOService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDTOServiceimpl.class);
    @Override
    public DepartmentDTO getDepartmentDTO(DepartmentDTO departmentDTO) {
        LOGGER.info("Into getDepartmentDTO method : {}", departmentDTO);
        try {
            return departmentDTO;
        }
        catch (Exception e){
            LOGGER.info(e.toString());
            return null;
        }
    }
}
