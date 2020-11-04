package com.futao.starter.fustack.db.entity.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author futao
 * @date 2020/11/2
 */
@Slf4j
@ComponentScan(basePackages = "com.futao.starter.fustack.db")
public class DbScanner {
    public DbScanner() {
        log.debug("load success");
    }
}
