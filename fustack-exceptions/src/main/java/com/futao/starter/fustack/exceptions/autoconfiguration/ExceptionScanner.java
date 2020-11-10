package com.futao.starter.fustack.exceptions.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author futao
 * @date 2020/11/10
 */
@Slf4j
@ComponentScan("com.futao.starter.fustack.exceptions")
public class ExceptionScanner {
    public ExceptionScanner() {
        log.debug("load success");
    }
}
