package com.futao.starter.fustack.auth.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author futao
 * @date 2020/11/10
 */
@Slf4j
@ComponentScan("com.futao.starter.fustack.auth")
public class AuthScanner {
    public AuthScanner() {
        log.debug("load success");
    }
}
