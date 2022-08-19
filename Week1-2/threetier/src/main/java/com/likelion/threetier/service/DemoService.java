package com.likelion.threetier.service;
import com.likelion.threetier.model.Object  ;
import com.likelion.threetier.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


import java.util.List;

public interface DemoService<W> {
    List<W> listElements();
    W elementById(String id);
}
