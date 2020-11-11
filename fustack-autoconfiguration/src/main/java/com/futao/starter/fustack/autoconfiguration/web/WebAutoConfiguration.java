package com.futao.starter.fustack.autoconfiguration.web;

import com.futao.starter.fustack.web.autoconfiguration.WebProperties;
import com.futao.starter.fustack.web.autoconfiguration.WebScanner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author futao
 * @date 2020/11/11
 */
@Configuration
@EnableConfigurationProperties(WebProperties.class)
@ConditionalOnClass(WebScanner.class)
@Import(WebScanner.class)
public class WebAutoConfiguration {
}
