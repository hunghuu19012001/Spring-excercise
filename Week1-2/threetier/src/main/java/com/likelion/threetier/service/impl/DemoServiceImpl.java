package com.likelion.threetier.service.impl;

import com.likelion.threetier.model.Object;
import com.likelion.threetier.repository.DemoRepository;
import com.likelion.threetier.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService<Object>{

    private final DemoRepository demoRepository;

    public DemoServiceImpl(DemoRepository demoRepository){this.demoRepository = demoRepository;}

    @Override
    public List<Object> listElements(){return demoRepository.findAll();}

    @Override
    public Object elementById(String id) {return demoRepository.findById(id);}

}
