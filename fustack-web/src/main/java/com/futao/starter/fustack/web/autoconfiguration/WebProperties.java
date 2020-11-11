package com.futao.starter.fustack.web.autoconfiguration;

import com.futao.starter.fustack.consts.Constants;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * @author futao
 * @date 2020/11/5
 */
@ConfigurationProperties(prefix = WebProperties.PREFIX)
public class WebProperties {

    public static final String PREFIX = Constants.System.FRAMEWORK_BASE_NAME + "." + Constants.Web.BASE_NAME;

    /**
     * 不对该类下的接口进行Rest封装
     */
    private Set<String> restSkipClassPaths;

    public Set<String> getRestSkipClassPaths() {
        return restSkipClassPaths;
    }

    public void setRestSkipClassPaths(Set<String> restSkipClassPaths) {
        this.restSkipClassPaths = restSkipClassPaths;
    }
}
