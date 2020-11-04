package com.futao.starter.fustack.tencent.cloud.shortmessage.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author futao
 * @date 2020/11/3
 */
@Slf4j
@ComponentScan("com.futao.starter.fustack.tencent.cloud.shortmessage")
public class TencentCloudShortMessageScanner {
    public TencentCloudShortMessageScanner() {
        log.debug("load success");
    }
}
