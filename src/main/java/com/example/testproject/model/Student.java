package com.example.testproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 描述
 *
 * @author chenjian
 * @version V1
 * @date 2021/4/9
 */
@Data
public class Student {

    private Integer id;

    private String studentName;

    private String sex;

    private String age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    List<Student> studentList;

    /*public Student(Integer id, String studentName, String sex, String age, Date createTime) {
        this.id = id;
        this.studentName = studentName;
        this.sex = sex;
        this.age = age;
        this.createTime = createTime;
    }*/
}
