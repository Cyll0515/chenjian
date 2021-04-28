package com.example.testproject.service;

import cn.hutool.Hutool;
import cn.hutool.core.lang.UUID;
import com.example.testproject.exception.BusinessException;
import com.example.testproject.jwt.JwtProperties;
import com.example.testproject.jwt.JwtTokenUtils;
import com.example.testproject.mapper.StudentMapper;
import com.example.testproject.model.Student;
import com.example.testproject.model.SysUser;
import com.example.testproject.model.dto.UserLoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.example.testproject.response.ReturnCode.ACCOUNT_PASSWORD_ERROR;

/**
 * 描述
 *
 * @author chenjian
 * @version V1
 * @date 2021/4/12
 */
@Slf4j
@Service
public class SysUserLoginService {

    @Autowired
    private SysUserService sysUserService;


    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //https://blog.csdn.net/solocoder/article/details/84141759
    //https://blog.csdn.net/qq_22200097/article/details/82747149

    //@Cacheable(cacheNames = "test1", key = "111")
    public String adminLogin(UserLoginDTO userLoginDTO) {
        //UserLoginDTO userLoginDTO
        //验证登录类型
        if (StringUtils.isEmpty(userLoginDTO.getLoginType())) {
            log.info("用户登录类型为null");
        }
        SysUser user = null;
        //判断登录类型
        if ("1".equals(userLoginDTO.getLoginType())) {
            //账号密码登录
            user = sysUserService.getSysUserByAccount(userLoginDTO.getAccount(), userLoginDTO.getPassword());
        }

        //判断是否合法
        if (user == null) {
            throw new BusinessException(ACCOUNT_PASSWORD_ERROR);
        }

        //根据用户id获取token
        String token = JwtTokenUtils.createToken(user.getId());

        //存入redis中，redis有效时间==为设置的token有效时间
        redisTemplate.opsForValue().set("token::"+user.getId(),token, JwtProperties.getExpires(), TimeUnit.SECONDS);

        //String token = JwtHelper.encode(JSON.toJSONString(jsonObject));
        return token;
    }

    /*@CacheEvict(cacheNames = "test", key = "111")
    public void deleteStudent() {
        log.info("删除redis中test下的111数据");
        Boolean delete = redisTemplate.delete("test1::111");
        log.info("删除" + delete);
    }*/

}
