package com.example.testproject.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 描述
 *
 * @author chenjian
 * @date 2021/4/14
 */
@Data
public class SysUserDTO {


    /**
     * 用户姓名
     */
    private String userName;
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
     * 身份证号
     */
    private String idCardNo;
    /**
     * 部门id
     */
    private Integer departmentId;
    /**
     * 职务id
     */
    private Integer positionId;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建人id
     */
    private Integer createUser;
    /**
     * 修改人id
     */
    private Integer updateUser;

}
