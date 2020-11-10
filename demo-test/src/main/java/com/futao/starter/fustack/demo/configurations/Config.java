package com.futao.starter.fustack.demo.configurations;

import com.futao.starter.fustack.auth.auth.UserAuth;
import com.futao.starter.fustack.auth.auth.impl.LoginUserAuth;
import com.futao.starter.fustack.auth.interceptors.UserAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author futao
 * @date 2020/11/10
 */
@Configuration
public class Config {

    @Bean
    public UserAuthInterceptor userAuthInterceptor() {
        return new UserAuthInterceptor();
    }

    @Bean
    public UserAuth userAuth() {
        return new LoginUserAuth();
    }
}
