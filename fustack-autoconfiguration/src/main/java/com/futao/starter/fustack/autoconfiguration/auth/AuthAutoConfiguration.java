package com.futao.starter.fustack.autoconfiguration.auth;

import com.futao.starter.fustack.auth.autoconfiguration.AuthProperties;
import com.futao.starter.fustack.auth.autoconfiguration.AuthScanner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author futao
 * @date 2020/11/10
 */
@Configuration
@ConditionalOnClass(AuthScanner.class)
@Import(AuthScanner.class)
@EnableConfigurationProperties(AuthProperties.class)
public class AuthAutoConfiguration {
}
