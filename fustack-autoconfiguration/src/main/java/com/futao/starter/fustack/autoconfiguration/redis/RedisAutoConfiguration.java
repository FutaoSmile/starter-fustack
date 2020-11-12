package com.futao.starter.fustack.autoconfiguration.redis;

import com.futao.starter.fustack.redis.autoconfiguration.RedisScanner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author futao
 * @date 2020/11/12
 */
@Import(RedisScanner.class)
@ConditionalOnClass(RedisScanner.class)
@Configuration
public class RedisAutoConfiguration {
}
