package com.futao.starter.fustack.wx.miniprogram;

import com.futao.starter.fustack.wx.miniprogram.exception.WxMiniProgramException;
import com.futao.starter.fustack.wx.miniprogram.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.*;

/**
 * @author futao
 * @date 2020/10/29
 */
@Slf4j
@Configuration
public class WxMiniProgramConfig {

    private static AccessTokenService ACCESS_TOKEN_SERVICE;

    /**
     * 忽略的Path的集合
     */
    private static final Set<String> IGNORE_PATH_SET = new HashSet<>();

    @Autowired
    private AccessTokenService accessTokenService;

    /**
     * PostConstruct注解的方法将会在依赖注入完成后被自动调用
     */
    @PostConstruct
    public void setWxMiniProgramProperties() {
        WxMiniProgramConfig.ACCESS_TOKEN_SERVICE = accessTokenService;
    }

    /**
     * 增强过的RestTemplate
     */
    public static final RestTemplate REST_TEMPLATE = new RestTemplate();

    /**
     * 追加请求参数queryString的拦截器
     *
     * @param paramsToAppend 需要追加的参数
     * @param ignorePathSet  忽略的path的集合
     * @return 拦截器
     */
    public static ClientHttpRequestInterceptor appendUrlQueryStringInterceptor(Map<String, Object> paramsToAppend, Set<String> ignorePathSet) {
        return (httpRequest, bytes, clientHttpRequestExecution) -> {
            if (paramsToAppend != null && paramsToAppend.size() > 0) {
                URI uri = httpRequest.getURI();
                // 未忽略
                if (ignorePathSet == null || (!ignorePathSet.contains(uri.getPath()))) {
                    //当前查询字符串
                    String rawQueryString = uri.getRawQuery();
                    StringBuffer sb = new StringBuffer();
                    paramsToAppend.forEach((k, v) -> sb.append(k)
                            .append("=")
                            .append(v)
                            .append("&"));
                    // 需要追加的queryString
                    String queryStringToAppend = sb.toString();
                    if (queryStringToAppend.endsWith("&")) {
                        queryStringToAppend = queryStringToAppend.substring(0, queryStringToAppend.lastIndexOf("&"));
                    }
                    //追加之后的请求参数
                    String qsAfterAppend = StringUtils.isBlank(rawQueryString) ? queryStringToAppend : rawQueryString + "&" + queryStringToAppend;
                    try {
                        Field stringField = URI.class.getDeclaredField("string");
                        stringField.setAccessible(true);
                        // 完整请求路径
                        String completeUrl = uri.getScheme() + "://" + uri.getHost() + uri.getPath() + "?" + qsAfterAppend;
                        stringField.set(uri, completeUrl);
                        log.debug("request complete url:{}", completeUrl);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        log.error("反射异常", e);
                        throw new WxMiniProgramException("反射异常", e);
                    }
                }
            }
            ClientHttpResponse httpResponse = clientHttpRequestExecution.execute(httpRequest, bytes);
            if (!httpResponse.getStatusCode().is2xxSuccessful()) {
                throw new WxMiniProgramException("访问微信小程序服务器失败:" + httpResponse.getStatusText());
            }
            return httpResponse;
        };
    }


    static {
        //兼容text/plain
        WxMiniProgramConfig.REST_TEMPLATE.getMessageConverters()
                .add(new TextPlainHttpMessageConverter());
        //需要忽略的地址: 请求token
        IGNORE_PATH_SET.add("/cgi-bin/token");

        // 添加拦截器
        WxMiniProgramConfig.REST_TEMPLATE.getInterceptors().add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                URI uri = request.getURI();
                // 原始请求参数
                String rawQueryString = uri.getRawQuery();
                if (!IGNORE_PATH_SET.contains(uri.getRawPath())) {
                    String queryStringToAppend = "access_token=" + WxMiniProgramConfig.ACCESS_TOKEN_SERVICE.get();
                    //追加之后的请求参数
                    String qsAfterAppend = StringUtils.isBlank(rawQueryString) ? queryStringToAppend : rawQueryString + "&" + queryStringToAppend;
                    try {
                        Field stringField = URI.class.getDeclaredField("string");
                        stringField.setAccessible(true);
                        // 完整请求路径
                        String completeUrl = uri.getScheme() + "://" + uri.getHost() + uri.getPath() + "?" + qsAfterAppend;
                        // 重新设置完整请求路径
                        stringField.set(uri, completeUrl);
                        log.debug("request complete url:{}", completeUrl);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        log.error("反射异常", e);
                        throw new WxMiniProgramException("反射异常", e);
                    }
                } else {
                    log.debug("ignore path :{}", uri.getPath());
                }
                ClientHttpResponse httpResponse = execution.execute(request, body);
                if (!httpResponse.getStatusCode().is2xxSuccessful()) {
                    throw new WxMiniProgramException("访问微信小程序服务器失败:" + httpResponse.getStatusText());
                }
                return httpResponse;
            }
        });

        HashMap<String, Object> uriVars = new HashMap<>();
        uriVars.put("p1", "v1");
        uriVars.put("p2", "v2");
        WxMiniProgramConfig.REST_TEMPLATE.setDefaultUriVariables(uriVars);
    }

    /**
     * 兼容text/plain
     */
    static class TextPlainHttpMessageConverter extends MappingJackson2HttpMessageConverter {
        public TextPlainHttpMessageConverter() {
            ArrayList<MediaType> supportedMediaTypes = new ArrayList<>(1);
            supportedMediaTypes.add(MediaType.TEXT_PLAIN);
            this.setSupportedMediaTypes(supportedMediaTypes);
        }
    }
}
