package com.futao.starter.fustack.redis.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author futao
 * @date 2020/11/12
 */
@Slf4j
@ComponentScan("com.futao.starter.fustack.redis")
public class RedisScanner {
    public RedisScanner() {
        log.debug("load success");
    }
}
