package com.example.testproject.service;

import com.example.testproject.mapper.StudentMapper;
import com.example.testproject.mapper.SysLogMapper;
import com.example.testproject.model.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author chenjian
 * @version V1
 * @date 2021/4/11
 */
@Service
public class SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;


    public void addSysLog(SysLog sysLog){
        sysLogMapper.addSysLog(sysLog);
    }

}
