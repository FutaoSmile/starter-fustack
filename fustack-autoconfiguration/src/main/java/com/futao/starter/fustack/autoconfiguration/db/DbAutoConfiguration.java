package com.futao.starter.fustack.autoconfiguration.db;

import com.futao.starter.fustack.db.DbScanner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author futao
 * @date 2020/11/2
 */
@Configuration
@ConditionalOnClass(DbScanner.class)
@Import(DbScanner.class)
@Slf4j
public class DbAutoConfiguration {
    public DbAutoConfiguration() {
        log.debug("load success");
    }
}
