package com.futao.starter.fustack.auth.beans;

import com.futao.starter.fustack.auth.auth.UserAuth;
import com.futao.starter.fustack.auth.auth.impl.DefaultUserAuth;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author futao
 * @date 2020/11/10
 */
@Configuration
public class Beans {

    @Bean
    @ConditionalOnMissingBean(UserAuth.class)
    public UserAuth userAuth() {
        return new DefaultUserAuth();
    }
}
