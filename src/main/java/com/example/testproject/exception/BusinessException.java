package com.example.testproject.exception;


import com.example.testproject.response.ReturnCode;

/**
 * 自定义业务异常类(业务主动提示的信息)
 *
 * @author chenjian
 * @date 2021/4/10
 */
public class BusinessException extends RuntimeException {

    protected int code;

    public BusinessException(String message) {
        super(message);
        this.code = ReturnCode.FAIL.getCode();
    }

    public BusinessException(ReturnCode returnCode) {
        super(returnCode.getMessage());
        this.code = returnCode.getCode();
    }

    public BusinessException(ReturnCode returnCode, Object... args) {
        super(String.format(returnCode.getMessage(), args));
        this.code = returnCode.getCode();
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
