package com.example.testproject.utils;

import cn.hutool.core.lang.UUID;

/**
 * uuid获取工具类
 *
 * @author chenjian
 * @version V1
 * @date 2021/4/14
 */
public class UUidUtils {

    public static String getUUid(){
        //UUID.fastUUID()
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","");
    }

}
