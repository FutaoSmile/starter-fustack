package com.futao.starter.fustack.autoconfiguration.tecent.cloud.shortmessage;

import com.futao.starter.fustack.tencent.cloud.shortmessage.autoconfiguration.TencentCloudShortMessageProperties;
import com.futao.starter.fustack.tencent.cloud.shortmessage.autoconfiguration.TencentCloudShortMessageScanner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author futao
 * @date 2020/11/3
 */
@ConditionalOnClass(TencentCloudShortMessageScanner.class)
@Configuration
@Import(TencentCloudShortMessageScanner.class)
@EnableConfigurationProperties(TencentCloudShortMessageProperties.class)
public class TencentCloudShortMessageAutoConfiguration {
}
