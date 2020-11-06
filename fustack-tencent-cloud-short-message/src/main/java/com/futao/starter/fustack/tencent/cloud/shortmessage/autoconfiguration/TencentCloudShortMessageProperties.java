package com.futao.starter.fustack.tencent.cloud.shortmessage.autoconfiguration;

import com.futao.starter.fustack.consts.Constants;
import com.futao.starter.fustack.tencent.cloud.shortmessage.exception.TencentCloudShortMessageException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author futao
 * @date 2020/11/3
 */
@ConfigurationProperties(prefix = TencentCloudShortMessageProperties.PROPERTY_PREFIX)
public class TencentCloudShortMessageProperties {

    public static final String PROPERTY_PREFIX = Constants.System.FRAMEWORK_BASE_NAME + "." + Constants.TencentCloudShortMessage.BASE_NAME;

    private String appId;

    private String secretId;

    private String secretKey;

    public String getAppId() {
        if (StringUtils.isBlank(appId)) {
            throw new TencentCloudShortMessageException("腾讯云短信AppId未设置");
        }
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecretId() {
        if (StringUtils.isBlank(secretId)) {
            throw new TencentCloudShortMessageException("腾讯云短信SecretId未设置");
        }
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        if (StringUtils.isBlank(secretKey)) {
            throw new TencentCloudShortMessageException("腾讯云短信SecretKey未设置");
        }
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
