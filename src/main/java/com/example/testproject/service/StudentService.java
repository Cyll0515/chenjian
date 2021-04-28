package com.example.testproject.service;

import com.example.testproject.aop.ControllerLog;
import com.example.testproject.exception.BusinessException;
import com.example.testproject.mapper.StudentMapper;
import com.example.testproject.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.testproject.response.ReturnCode.NULL_USER;
import static com.example.testproject.response.ReturnCode.USER_STUDENT_LIST_NULL;

/**
 * 描述
 *
 * @author chenjian
 * @version V1
 * @date 2021/4/9
 */
@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;


    public List<Student> test111() {
        List<Student> list = studentMapper.getStudentList();
        //List<Student> list = null;
        /*if(list == null){
            throw new BusinessException(USER_STUDENT_LIST_NULL);
        }*/
        System.out.println("打印项目666" + list.size());
        log.info("打印项目");
        return list;
    }

    public void test222() {
        List<Student> list = studentMapper.getStudentList();
        catList(list);
    }

    private static void catList(List<Student> list) {
        for (Student s : list) {
            System.out.println("学生：" + s.getStudentName() + "---性别：" + s.getSex() + "---年龄：" + s.getAge());
        }
        System.out.println("========================================");
    }

}
