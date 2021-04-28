package com.example.testproject.controller;

import com.example.testproject.model.SysUser;
import com.example.testproject.model.dto.UserLoginDTO;
import com.example.testproject.response.ReturnData;
import com.example.testproject.service.SysUserLoginService;
import com.example.testproject.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统用户登录
 *
 * @author chenjian
 * @date 2021/4/12
 */
@RequestMapping("/test/login")
@RestController
public class SysUserLoginController {

    @Autowired
    private SysUserLoginService sysUserLoginService;

    @GetMapping("/admin")
    public ReturnData adminLogin(@RequestBody UserLoginDTO userLoginDTO){

        return new ReturnData<>(sysUserLoginService.adminLogin(userLoginDTO));
    }

    /*@GetMapping("/gourd")
    public ReturnData gourdLogin(){

        return new ReturnData<>(sysUserLoginService.gourdLogin());
    }

    @GetMapping("/devil")
    public ReturnData devilLogin(){

        return new ReturnData<>(sysUserLoginService.devilLogin());
    }*/

}
