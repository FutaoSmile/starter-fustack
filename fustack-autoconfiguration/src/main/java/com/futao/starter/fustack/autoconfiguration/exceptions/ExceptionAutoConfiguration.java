package com.futao.starter.fustack.autoconfiguration.exceptions;

import com.futao.starter.fustack.exceptions.autoconfiguration.ExceptionScanner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author futao
 * @date 2020/11/10
 */
@Configuration
@ConditionalOnClass(ExceptionScanner.class)
@Import(ExceptionScanner.class)
public class ExceptionAutoConfiguration {
}
