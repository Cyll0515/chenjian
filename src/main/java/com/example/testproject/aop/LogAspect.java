package com.example.testproject.aop;

import com.example.testproject.model.SysLog;
import com.example.testproject.response.ReturnData;
import com.example.testproject.service.SysLogService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;

/**
 * 日志切面类
 *
 * @author chenjian
 * @date 2021/4/11
 */
@Slf4j
@Aspect
@Configuration
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.example.testproject.aop.ControllerLog)")
    public void logPointcut() {
        //切入点本身无行为，仅仅是引入切面
    }

    /**
     * 执行切入点代码之前执行
     */
    @Before("logPointcut()")
    public void doBefore() {
        log.error("进入controller");
    }

    /**
     * 执行切入点代码之后执行，无论是否异常，都会执行
     */
    @After("logPointcut()")
    public void doAfter() {
        log.error("333");
    }

    /**
     * 执行切入点代码之后执行，无异常时执行，且执行在@After之前
     */
    @AfterReturning(returning = "returnData", pointcut = "logPointcut()")
    public void doAfterReturning(ReturnData<?> returnData) {
        log.info("请求结果：" + returnData.toString());
        //log.info("注解参数：" + controllerLog.value());
    }

    /**
     * 执行切入点代码之后执行，当出现异常时执行，且执行在@After之前
     */
    @AfterThrowing("logPointcut()")
    public void doAfterThrowing(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("555");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        StringBuilder params = new StringBuilder();
        int index = 0;
        for (String param : request.getParameterMap().keySet()) {
            params.append(index++ == 0 ? "" : "&").append(param).append("=").append(request.getParameter(param));
        }

        params.append(new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .writeValueAsString(Arrays.toString(joinPoint.getArgs())));

        //添加日志
        addLog(request, params.toString());

    }

    /**
     * 环绕增强
     *
     * @param controllerLog 注解对象
     * @return Object 返给web的对象
     */
    @Around("@annotation(controllerLog)")
    public Object doAround(ProceedingJoinPoint joinPoint, ControllerLog controllerLog) throws Throwable {
        log.error("666");
        log.error("注解参数：" + controllerLog.value());
        Object result = joinPoint.proceed();

        log.error("777");
        return result;
    }


    /**
     * 将日志添加入数据库
     *
     * @param request 请求
     * @param params  参数
     * @return 日志实体
     */
    private void addLog(HttpServletRequest request, String params) {
        SysLog sysLog = new SysLog();
        sysLog.setRequestIp(request.getRemoteAddr());
        sysLog.setRequestUri(request.getRequestURI());
        sysLog.setRequestMethod(request.getMethod());
        sysLog.setRequestParams(params);
        sysLog.setUserAgent(request.getHeader("user-agent"));
        sysLog.setCreateTime(new Date());

        sysLogService.addSysLog(sysLog);

    }


}
