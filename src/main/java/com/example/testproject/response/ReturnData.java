package com.example.testproject.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回实体类
 *
 * @author chenjian
 * @date 2021/4/10
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnData<T> implements Serializable {

    private static final long serialVersionUID = -6905846287358909524L;

    /**
     * 返回的状态码
     */
    private Integer returnCode;
    /**
     * 返回的信息
     */
    private String returnInfo;
    /**
     * 返回的实体类或者列表等一些信息
     */
    private T returnData;


    public ReturnData() {
        this(ReturnCode.SUCCESS);
    }

    public ReturnData(T returnData) {
        this(ReturnCode.SUCCESS, returnData);
    }
    public ReturnData(int returnCode, String returnInfo) {
        this(returnCode, returnInfo, null);
    }



    public ReturnData(ReturnCode responseEnum) {
        this(responseEnum, null);
    }
    public ReturnData(ReturnCode responseEnum, T returnData) {
        this(responseEnum.getCode(), responseEnum.getMessage(), returnData);
    }
    public ReturnData(int returnCode, String returnInfo, T returnData) {
        this.returnCode = returnCode;
        this.returnInfo = returnInfo;
        this.returnData = returnData;
    }

    public ReturnData success() {
        this.returnCode = ReturnCode.SUCCESS.getCode();
        this.returnInfo = ReturnCode.SUCCESS.getMessage();
        return this;
    }

    public ReturnData error() {
        return error("");
    }

    public ReturnData error(int code, Exception e) {
        this.returnCode = code;
        if (e.getCause() != null){
            this.returnInfo = e.getCause().toString() +":" + e.getMessage();
        } else {
            this.returnInfo = e.getMessage();
        }
        return this;
    }

    public ReturnData error(String errorMsg) {
        this.returnCode = ReturnCode.FAIL.getCode();
        this.returnInfo = errorMsg;
        return this;
    }

    /*public String toJsonStr(){
        return JSON.toJSONString(this);
    }*/
    /*public ReturnData<T> setData(T returnData) {
        this.returnData = returnData;
        return this;
    }*/

}

