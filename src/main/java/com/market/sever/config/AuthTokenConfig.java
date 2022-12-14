package com.market.sever.config;

import com.market.sever.filter.AuthHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author u7382548
 */

@Configuration
public class AuthTokenConfig implements WebMvcConfigurer {
    @Autowired
    AuthHandlerInterceptor authHandlerInterceptor;

    /**
     * Excepting '/login' api, other requests are redirected to authHandlerInterceptor.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authHandlerInterceptor)
                .addPathPatterns("/market/api/**")
                .excludePathPatterns("/market/api/user/login","/market/api/user/register");
    }
}


