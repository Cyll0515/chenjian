package com.example.testproject.service;

import com.example.testproject.utils.UUidUtils;
import com.example.testproject.constant.BooleanConstants;
import com.example.testproject.mapper.SysUserMapper;
import com.example.testproject.model.SysUser;
import com.example.testproject.model.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 系统用户service
 *
 * @author chenjian
 * @date 2021/4/12
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     *
     *
     * @param
     * @return
     * @author chenjian
     * @date 2021/4/14 16:51
     */
    public SysUser getSysUserByAccount(String account, String password) {
        return sysUserMapper.getSysUserByAccount(account, password);
    }

    public void addSysUser(SysUserDTO sysUserDTO){

        SysUser sysUser = new SysUser();
        sysUser.setId(UUidUtils.getUUid());
        sysUser.setUserName(sysUserDTO.getUserName());
        sysUser.setUserType(sysUserDTO.getUserType());
        sysUser.setAccount(sysUserDTO.getAccount());
        sysUser.setPassword(sysUserDTO.getPassword());
        sysUser.setIdCardNo(sysUserDTO.getIdCardNo());
        sysUser.setDepartmentId(sysUserDTO.getDepartmentId());
        sysUser.setPositionId(sysUserDTO.getPositionId());
        sysUser.setPhone(sysUserDTO.getPhone());
        sysUser.setEmail(sysUserDTO.getEmail());
        sysUser.setCreateUser(sysUserDTO.getCreateUser());
        sysUser.setCreateTime(new Date());
        sysUser.setValid(BooleanConstants.BOOLEAN_TRUE);
        sysUserMapper.addSysUser(sysUser);
    }


}
