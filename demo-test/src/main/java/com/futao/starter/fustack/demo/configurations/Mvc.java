package com.futao.starter.fustack.demo.configurations;

import com.futao.starter.fustack.auth.interceptors.UserAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author futao
 * @date 2020/11/10
 */
@Configuration
public class Mvc implements WebMvcConfigurer {

    @Autowired
    private UserAuthInterceptor userAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthInterceptor).addPathPatterns("/**");
    }
}
