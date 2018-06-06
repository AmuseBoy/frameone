package com.amuse.frameone.common.util;


import com.amuse.frameone.common.model.Jwt;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @ClassName JwtUtil
 * @Description jwt生产token、解析token实现类
 * @Author 刘培振
 * @Date 2018/5/29 15:39
 * @Version 1.0
 */
public class JwtUtil {

    private final static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    public static Claims parseJWT(String jsonWebToken,Jwt jwt){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(jwt.getBase64Secret()))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception e) {
            logger.info("{}",e);
            return null;
        }
    }


    /**
     * 生成jwt
     * @param username
     * @param roles
     * @param jwt
     * @return
     */
    public static String createJWT(String username, String roles, Jwt jwt){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMills = System.currentTimeMillis();
        Date now = new Date(nowMills);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwt.getBase64Secret());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ","JWT")
                .claim("user_name",username)
                .claim("user_role",roles)
                .setIssuer(jwt.getName())
                .setAudience(jwt.getClientId())
                .signWith(signatureAlgorithm,signingKey);

        //添加token过期时间
        if(jwt.getExpiresSecond()>=0){
            long expMills = nowMills + jwt.getExpiresSecond();
            Date exp = new Date(expMills);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }
}
