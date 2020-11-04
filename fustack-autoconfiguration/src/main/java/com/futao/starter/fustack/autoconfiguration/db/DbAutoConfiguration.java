package com.futao.starter.fustack.autoconfiguration.db;

import com.futao.starter.fustack.db.entity.autoconfiguration.DbScanner;
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
public class DbAutoConfiguration {
}
