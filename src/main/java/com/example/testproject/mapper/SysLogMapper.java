package com.example.testproject.mapper;

import com.example.testproject.model.SysLog;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SysLogMapper {

    void addSysLog(SysLog sysLog);

}
