package com.futao.starter.fustack.web.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author futao
 * @date 2020/11/11
 */
@Slf4j
@ComponentScan("com.futao.starter.fustack.web")
public class WebScanner {
    public WebScanner() {
        log.debug("load success");
    }
}
