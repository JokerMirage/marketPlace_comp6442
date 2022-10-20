package com.market.sever.filter;

import com.market.sever.config.CommonResult;
import com.market.sever.config.TokenAuthExpiredException;
import com.market.sever.constant.CommonCode;
import com.market.sever.entity.TokenUtil;
import com.mysql.cj.xdevapi.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/**
 * @author u7382548
 */
@Slf4j
@Component
@PropertySource("classpath:application.properties")
public class AuthHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    TokenUtil tokenUtil;
    private String privateKey = "Je sais les cieux crevant en éclairs, et les trombes";
    private Long yangToken = Long.valueOf(1000000);
    private Long oldToken = Long.valueOf(3000000);
    /**
     * 权限认证的拦截操作.
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        log.info("=======进入拦截器========");
        // 如果不是映射到方法直接通过,可以访问资源.
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        //为空就返回错误
        String token = httpServletRequest.getHeader("token");
        if (null == token || "".equals(token.trim())) {
            httpServletResponse.sendError(CommonCode.TOKEN_FAIL.getCode(),CommonCode.TOKEN_FAIL.getMessage());
            return false;
        }
        log.info("==============token:" + token);
        Map<String, String> map = tokenUtil.parseToken(token);
        String userId = map.get("userId");
        long timeOfUse = System.currentTimeMillis() - Long.parseLong(map.get("timeStamp"));
        //1.判断 token 是否过期
        //年轻 token
        if (timeOfUse < yangToken) {
            log.info("年轻 token");
            return true;
        }
        //老年 token 就刷新 token
        else if (timeOfUse >= yangToken && timeOfUse < oldToken) {
            httpServletResponse.setHeader("token",tokenUtil.getToken(userId));
            return true;
        }
        //过期 token 就返回 token 无效.
        else {
            httpServletResponse.sendError(CommonCode.TOKEN_FAIL.getCode(),CommonCode.TOKEN_FAIL.getMessage());
            throw new TokenAuthExpiredException();
        }

    }

}

