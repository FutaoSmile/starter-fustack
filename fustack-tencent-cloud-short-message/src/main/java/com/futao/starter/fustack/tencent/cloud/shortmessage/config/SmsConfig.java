package com.futao.starter.fustack.tencent.cloud.shortmessage.config;

import com.futao.starter.fustack.tencent.cloud.shortmessage.autoconfiguration.TencentCloudShortMessageProperties;
import com.tencentcloudapi.common.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author futao
 * @date 2020/11/3
 */
@Configuration
public class SmsConfig {

    @Autowired
    private TencentCloudShortMessageProperties tencentCloudShortMessageProperties;

    @Bean
    public Credential cred() {
        return new Credential(tencentCloudShortMessageProperties.getSecretId(), tencentCloudShortMessageProperties.getSecretKey());
    }

}
