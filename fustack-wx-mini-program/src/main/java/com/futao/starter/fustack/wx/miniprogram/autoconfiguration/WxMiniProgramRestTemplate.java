package com.futao.starter.fustack.wx.miniprogram.autoconfiguration;

import com.futao.starter.fustack.wx.miniprogram.exception.WxMiniProgramException;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author futao
 * @date 2020/10/29
 */
public class WxMiniProgramRestTemplate extends RestTemplate {

    @Override
    public void setInterceptors(List<ClientHttpRequestInterceptor> interceptors) {
        super.setInterceptors(interceptors);
        interceptors.add((httpRequest, bytes, clientHttpRequestExecution) -> {
            ClientHttpResponse httpResponse = clientHttpRequestExecution.execute(httpRequest, bytes);
            if (!httpResponse.getStatusCode().is2xxSuccessful()) {
                throw new WxMiniProgramException("访问微信小程序服务器失败:" + httpResponse.getStatusText());
            }
            return httpResponse;
        });
    }

}
