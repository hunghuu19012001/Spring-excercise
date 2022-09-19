package com.example.MyBatis.repository;

import com.example.MyBatis.Entity.Person;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PersonRopository {
    @Select("Select count(1) from PERSON")
    int count();

    @Select("SELECT*FROM PERSON WHERE id = #{id}")
    @Results(value = {@Result(property = "id", column = "id"),
        @Result(property = "fullName", column = "fullName"),
        @Result(property = "dateOfBirth", column = "dateOfBirth")}
    )
    Person findById(long id);

    @Delete("DETELE FROM PERSON WHERE id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO PERSON(fullName, dateOfBirth)"+"VALUE(#{fullName}, #{dateOfBirth})")

    @Options(useGeneratedKeys = true, keyProperty = "id")

    int insert(Person person);
    @Update("Update PERSON set fullName=#{fullName} where id=#{id}")
    int update(Person person);
}
