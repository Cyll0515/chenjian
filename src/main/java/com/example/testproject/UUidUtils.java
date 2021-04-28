package com.example.testproject;

import cn.hutool.core.lang.UUID;

/**
 * 描述
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
