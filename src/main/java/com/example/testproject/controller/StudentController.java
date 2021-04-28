package com.example.testproject.controller;

import com.example.testproject.aop.ControllerLog;
import com.example.testproject.model.Student;
import com.example.testproject.model.dto.UserLoginDTO;
import com.example.testproject.response.ReturnData;
import com.example.testproject.service.StudentService;
import com.example.testproject.service.SysUserLoginService;
import com.example.testproject.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述
 *
 * @author chenjian
 * @version V1
 * @date 2021/4/9
 */
@RequestMapping("/test/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SysUserLoginService sysUserLoginService;

    @ControllerLog("xxxx")
    @GetMapping("/test")
    public ReturnData test111(){
        return new ReturnData<>(studentService.test111());
    }

    //@ControllerLog("xxxx")
    /*@GetMapping("/test1")
    public ReturnData test222(@RequestBody UserLoginDTO userLoginDTO){
        return new ReturnData<>(sysUserLoginService.adminLogin(userLoginDTO));
        //studentService.test222();
    }*/

}
