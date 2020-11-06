package com.futao.starter.fustack.wx.miniprogram.service.impl;

import com.futao.starter.fustack.consts.Constants;
import com.futao.starter.fustack.wx.miniprogram.autoconfiguration.WxMiniProgramConfig;
import com.futao.starter.fustack.wx.miniprogram.autoconfiguration.WxMiniProgramProperties;
import com.futao.starter.fustack.wx.miniprogram.model.resuslt.AuthCode;
import com.futao.starter.fustack.wx.miniprogram.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author futao
 * @date 2020/10/29
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private WxMiniProgramProperties wxMiniProgramProperties;

    @Override
    public AuthCode getOpenIdByCode(String code) {

        String uriString = UriComponentsBuilder.fromHttpUrl(Constants.WxMiniProgram.WX_API_DOMAIN + "/sns/jscode2session")
                .queryParam("appid", wxMiniProgramProperties.getAppId())
                .queryParam("secret", wxMiniProgramProperties.getAppSecret())
                .queryParam("js_code", code)
                .queryParam("grant_type", "authorization_code")
                .build()
                .encode()
                .toUriString();


        ResponseEntity<AuthCode> authCodeResponseEntity = WxMiniProgramConfig.REST_TEMPLATE.getForEntity(uriString, AuthCode.class);
        AuthCode authCode = authCodeResponseEntity.getBody();
        return authCode;
    }
}
