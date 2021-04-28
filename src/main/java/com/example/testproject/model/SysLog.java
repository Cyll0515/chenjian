package com.example.testproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 系统日志
 *
 * @author chenjian
 */
@Data
public class SysLog {

    /**
     * 日志id
     */
    private Integer logId;
    /**
     * 请求ip
     */
    private String requestIp;
    /**
     * 请求路径
     */
    private String requestUri;
    /**
     * 请求方式(get,post)
     */
    private String requestMethod;
    /**
     * 请求参数
     */
    private String requestParams;
    /**
     *
     */
    private String userAgent;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
