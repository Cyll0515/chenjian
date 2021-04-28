package com.example.testproject.mapper;

import com.example.testproject.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> getStudentList();

}
