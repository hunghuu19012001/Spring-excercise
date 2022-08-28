package com.example.Week22.repository;

import com.example.Week22.entity.dto.Departmentdto;
import com.example.Week22.entity.dto.Employeedto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MBRepository {
    @Select("SELECT * , (SELECT COUNT(*) from EMPLOYEE where department_id = #{departmentId}) as num_employee " +
            "FROM DEPARTMENT " +
            "WHERE department_id = #{departmentId}")
    @Results(value = {@Result(property="departmentId", column="department_id"),
            @Result(property="dept_name", column = "dept_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "numEmployee", column = "num_employee")})
    Departmentdto findDepartmentById(String departmentId);

    @Select("SELECT *" +
            "FROM EMPLOYEE " +
            "WHERE employee_id = #{id}")
    @Results(value = {@Result(property="name", column="name"),
            @Result(property="birthDate", column = "birth_date"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "department", column = "department", one = @One(select = "findDepartmentById"))})
    Employeedto findEmployeeById(Long id);
}
