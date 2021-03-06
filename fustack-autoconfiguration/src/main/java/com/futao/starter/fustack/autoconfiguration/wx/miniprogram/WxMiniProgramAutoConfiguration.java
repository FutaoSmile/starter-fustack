package com.futao.starter.fustack.autoconfiguration.wx.miniprogram;

import com.futao.starter.fustack.wx.miniprogram.autoconfiguration.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 微信小程序自动配置类
 *
 * @author futao
 * @date 2020/10/29
 */
@Configuration
@ConditionalOnClass(WxMiniProgramScanner.class)
@EnableConfigurationProperties(WxMiniProgramProperties.class)
@Import(WxMiniProgramScanner.class)
public class WxMiniProgramAutoConfiguration {
}
