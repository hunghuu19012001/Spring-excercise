package com.likelion.threetier.model;

import org.springframework.stereotype.Component;

@Component
public class Object {
    private String id;
    private String name;
    private Integer age;
    private String hobby;

    public Object(String id, String name, Integer age, String hobby){
        this.id=id;
        this.name=name;
        this.age=age;
        this.hobby=hobby;

    }
    public Object(){
    }
    public String getId(){return id;}
    public void setId(String id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public Integer getAge(){return age;}
    public void setAge(Integer age){this.age = age;}

    public String getHobby(){return hobby;}
    public void setHobby(String hobby){this.hobby = hobby;}

    @Override
    public String toString(){
        return "Object{" + "id" + id + '\'' + ", Tên= '" + name + '\'' + ", Tuổi="+age+ ", Sở thích='" + hobby + '\''+'}';

    }


}
