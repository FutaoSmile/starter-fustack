package com.futao.starter.fustack.wx.miniprogram.autoconfiguration;

import com.futao.starter.fustack.consts.Consts;
import com.futao.starter.fustack.wx.miniprogram.exception.WxMiniProgramException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 微信小程序配置类
 *
 * @author futao
 * @date 2020/10/29
 */
@ConfigurationProperties(prefix = WxMiniProgramProperties.PROPERTY_PREFIX)
public class WxMiniProgramProperties {

    /**
     * 微信小程序配置前缀
     */
    public static final String PROPERTY_PREFIX = Consts.System.FRAMEWORK_BASE_NAME + "." + Consts.WxMiniProgram.WX_MINI_PROGRAM_BASE_NAME;

    /**
     * AppID(小程序ID)
     */
    private String appId;

    /**
     * AppSecret(小程序密钥)
     */
    private String appSecret;

    public String getAppId() {
        if (StringUtils.isBlank(appId)) {
            throw new WxMiniProgramException("微信小程序AppId未设置");
        }
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        if (StringUtils.isBlank(appSecret)) {
            throw new WxMiniProgramException("微信小程序AppSecret未设置");
        }
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
