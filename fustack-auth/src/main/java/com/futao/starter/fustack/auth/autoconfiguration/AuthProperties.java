package com.futao.starter.fustack.auth.autoconfiguration;

import com.futao.starter.fustack.consts.Constants;
import com.futao.starter.fustack.exceptions.LogicException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author futao
 * @date 2020/11/11
 */
@ConfigurationProperties(prefix = AuthProperties.PREFIX)
public class AuthProperties {

    public static final String PREFIX = Constants.System.FRAMEWORK_BASE_NAME + "." + Constants.Auth.BASE_NAME;

    /**
     * jwt加密的key
     */
    private String jwtSignKey;

    /**
     * jwt有效时长
     */
    private Duration jwtDuration;


    public String getJwtSignKey() {
        if (StringUtils.isBlank(jwtSignKey)) {
            throw new LogicException("jwtSignKey未配置");
        }
        return jwtSignKey;
    }

    public void setJwtSignKey(String jwtSignKey) {
        this.jwtSignKey = jwtSignKey;
    }

    public Duration getJwtDuration() {
        if (StringUtils.isBlank(jwtSignKey)) {
            throw new LogicException("jwtDuration未配置");
        }
        return jwtDuration;
    }

    public void setJwtDuration(Duration jwtDuration) {
        this.jwtDuration = jwtDuration;
    }
}