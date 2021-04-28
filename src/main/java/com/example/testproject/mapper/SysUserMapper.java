package com.example.testproject.mapper;

import com.example.testproject.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述
 *
 * @author chenjian
 * @date 2021/4/12
 */
@Mapper
public interface SysUserMapper {

    /**
     * 根据账号和密码查询用户信息
     */
    SysUser getSysUserByAccount(@Param("account") String account, @Param("password") String password);

    /**
     * 添加用户
     */
    void addSysUser(SysUser sysUser);

}
