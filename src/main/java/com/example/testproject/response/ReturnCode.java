package com.example.testproject.response;

import java.util.Arrays;

/**
 * 返回错误码枚举类
 *
 * @author chenjian
 * @date 2021/4/10
 */
public enum ReturnCode {

    /**
     * 全局枚举错误码
     */
    SUCCESS(200,"请求成功"),
    FAIL(400,"请求失败"),
    BAD_CREDENTIALS(401,"凭证无效"),
    BAD_PERMISSION(402,"无此访问权限"),
    UNKNOWN_USER(403,"匿名用户，需要登录"),
    NULL_USER(417,"无此用户信息"),
    LOGIN_TIMEOUT(420,"登录超时，请重新登录"),
    VIOLATION_ERROR(427,"参数错误，请检查参数"),
    SYSTEM_ERR(500,"请求失败，系统异常"),
    UNKONW_ERROR(9999, "未知错误"),

    /**
     * 全局通用
     */
    USER_STUDENT_LIST_NULL(200001,"该老师没有学生信息"),
    ACCOUNT_PASSWORD_ERROR(200002, "账号或密码错误");

    private int code;
    private String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取code
     */
    public int getCode() {
        return code;
    }
    /**
     * 获取message
     */
    public String getMessage() {
        return message;
    }

    /*public static boolean isFail(ReturnData returnData) {
        return returnData != null && !isSuccess(returnData.getReturnCode());
    }
    public static boolean isSuccess(ReturnData returnData) {
        return returnData != null && isSuccess(returnData.getReturnCode());
    }*/

    public static boolean isSuccess(Integer code) {
        return SUCCESS.getCode() == code;
    }

    public static boolean isSuccess(String code) {
        return String.valueOf(SUCCESS.getCode()).equals(code);
    }

    /**
     * 根据code获取ReturnCode
     */
    public static ReturnCode getReturnCodeByCode(int code) {
        return Arrays.asList(ReturnCode.values()).stream().filter(item -> item.code == code).findFirst().orElse(UNKONW_ERROR);
    }
}
