package com.market.sever.entity;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
/**
 * @author u7382548
 */
@Component
public class TokenUtil {
    private final String privateKey = "Je sais les cieux crevant en éclairs, et les trombes";

    /**
     * Encoding token by HAMC256 encryption.
     */
    public String getToken(String email) {
        //这个是放到负载payLoad 里面,魔法值可以使用常量类进行封装.
        String token = JWT
                .create()
                .withClaim("email" ,email)
                .withClaim("timeStamp", System.currentTimeMillis())
                .sign(Algorithm.HMAC256(privateKey));
        return token;
    }

    /**
     * decoding token.
     * {
     * "userId": "3412435312",
     * "timeStamp": "134143214"
     * }
     */
    public Map<String, String> parseToken(String token) {
        HashMap<String, String> map = new HashMap<>();
        DecodedJWT decodedjwt = JWT.require(Algorithm.HMAC256(privateKey))
                .build().verify(token);
        Claim userId = decodedjwt.getClaim("userId");
        Claim timeStamp = decodedjwt.getClaim("timeStamp");
        map.put("userId", userId.asString());
        map.put("timeStamp", timeStamp.asLong().toString());
        return map;
    }
}

