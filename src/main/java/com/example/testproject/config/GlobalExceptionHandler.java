package com.example.testproject.config;

import com.example.testproject.exception.BusinessException;
import com.example.testproject.response.ReturnCode;
import com.example.testproject.response.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author chenjian
 * @date 2021/4/10
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    public GlobalExceptionHandler() {
    }

    /**
     * 业务异常
     * 
     * @param e 自定义业务异常类
     */
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ReturnData businessException(BusinessException e) {
        log.error("业务逻辑异常，异常代码： ex={}", e.getMessage(), e);
        return new ReturnData().error(e.getCode(), e);
    }

    /**
     * 系统运行时异常
     *
     * @param
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ReturnData exception(Exception e) {
        log.error("系统运行时异常,异常代码： ex={}", e.getMessage(), e);
        return new ReturnData().error(ReturnCode.SYSTEM_ERR.getCode(), e);
    }

    /*@ExceptionHandler({MethodArgumentNotValidException.class})
    public ReturnData<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("参数信息异常,异常信息：{}", e.getMessage());
        ObjectError objectError = (ObjectError)e.getBindingResult().getAllErrors().get(0);
        return new ReturnData(ReturnCode.VIOLATION_ERROR.getCode(), objectError.toString());
    }*/

}
