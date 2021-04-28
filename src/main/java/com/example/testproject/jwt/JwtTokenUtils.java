package com.example.testproject.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * 描述
 *
 * @author chenjian
 * @version V1
 * @date 2021/4/14
 */
public class JwtTokenUtils {

    public static String createToken(String str)  {

        // 获取加密算法(HS256)
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //把秘钥字符串还原成字节数组
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JwtProperties.getSecret());

        //把秘钥字节数组，通过加密算法(HS256)，再次加密做成秘钥
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //生成签发时间-生成JWT token的时间
        long nowMillis = System.currentTimeMillis();
        //token过期时间
        long expMillis = System.currentTimeMillis() + JwtProperties.getExpires() * 1000;

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(str)
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(new Date(expMillis))
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

    /**
     * 从token获取用户id
     */
    public static String getUserId(String token)  {
        return getTokenBody(token).getSubject();
    }

    /**
     * 获取token：获取Claims对象
     */
    private static Claims getTokenBody(String token)  {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(JwtProperties.getSecret()))
                .parseClaimsJws(token).getBody();
        return claims;
    }


}
