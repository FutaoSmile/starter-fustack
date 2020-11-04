package com.futao.starter.fustack.wx.miniprogram.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author futao
 * @date 2020/10/29
 */
@Slf4j
@ComponentScan(basePackages = "com.futao.starter.fustack.wx.miniprogram")
public class WxMiniProgramScanner {
    public WxMiniProgramScanner() {
        log.debug("load success");
    }
}
