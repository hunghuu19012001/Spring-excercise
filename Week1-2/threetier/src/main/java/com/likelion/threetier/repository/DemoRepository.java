package com.likelion.threetier.repository;
import com.likelion.threetier.model.Object;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DemoRepository {
    List<Object> listObject = new ArrayList<Object>();

    @PostConstruct
    public void init(){
        listObject.add(new Object("Object1", "A", 21, "travel"));
        listObject.add(new Object("Object2", "B", 22, "Food"));
        listObject.add(new Object("Object3", "C", 23, "Sing"));
        listObject.add(new Object("Object4", "D", 24, "Football"));
        listObject.add(new Object("Object5", "E", 25, "Sleep"));
    }
    public List<Object> findAll(){
        return listObject;
    }

    public Object findById(String id){
        for (Object element : listObject) {
            if (id.equals(element.getId())) {
                return new Object(element.getId(),
                element.getName(),
                        element.getAge(),
                        element.getHobby());
            }
        }
        return null;
    }
}
