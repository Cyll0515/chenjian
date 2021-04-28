package com.example.testproject.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * jwt配置文件
 * @author Sariel
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * 秘钥
     */
    private static String secret;

    /**
     * 有效时间
     */
    private static long expires;

    @Value("${jwt.secret:0}")
    public void setSecret(String secret) {
        JwtProperties.secret = secret;
    }

    @Value("${jwt.expires:1800}")
    public void setExpires(long expires) {
        JwtProperties.expires = expires;
    }

    public static long getExpires() {
        return expires;
    }

    public static String getSecret() {
        return secret;
    }

}
