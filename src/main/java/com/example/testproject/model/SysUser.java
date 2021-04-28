package com.example.testproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 系统用户表
 *
 * @author chenjian
 */
@Data
public class SysUser {

    /**
     * 主键id
     */
    private String id;
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
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改人id
     */
    private Integer updateUser;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 数据是否失效：0:-失效，1-有效
     */
    private String valid;

}
