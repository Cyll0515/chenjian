package com.example.testproject.model.dto;

import lombok.Data;

/**
 * 描述
 *
 * @author chenjian
 * @date 2021/4/12
 */
@Data
public class UserLoginDTO {

    /**
     * 登录类型：1-账号密码；2-手机号密码；3-手机号验证码；4-邮箱密码；5-邮箱验证码
     */
    private String loginType;
    /**
     * 用户类型：1-学生；2-老师
     */
    private String userType;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
}
