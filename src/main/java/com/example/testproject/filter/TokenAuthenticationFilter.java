package com.example.testproject.filter;


import com.alibaba.fastjson.JSON;
import com.example.testproject.jwt.JwtTokenUtils;
import com.example.testproject.response.ReturnCode;
import com.example.testproject.response.ReturnData;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * 拦截请求进行token验证
 *
 * @author chenjian
 */
public class TokenAuthenticationFilter implements HandlerInterceptor {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String token = request.getHeader("Authentication");

        //判断token是否为空
        if (StringUtils.isNotBlank(token)) {
            // 根据 token 拿到用户id
            String userId = JwtTokenUtils.getUserId(token);

            // 使用userId从redis中获取数据token
            Object sourceToken = redisTemplate.opsForValue().get("token::"+userId);

            //如果能够获取到数据，说明token未过期
            if (Objects.nonNull(sourceToken)) {
                // 如果两个token相等，代表 token有效
                if (Objects.equals(token, sourceToken)) {

                    //request.setAttribute("user", weChatMiniProgramsService.getUser(login));
                    // 请求放行
                    return true;
                }
            }
        }
        //从请求头中获取不到token说明未登录，阻止该请求访问资源
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //因为需要把false返回到HandlerInterceptor方法，所以不能使用业务异常处理，需要手动写入到response中
        response.getWriter().write(JSON.toJSONString(new ReturnData(ReturnCode.BAD_CREDENTIALS.getCode(), ReturnCode.BAD_CREDENTIALS.getMessage())));

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //do nothing
    }
}
