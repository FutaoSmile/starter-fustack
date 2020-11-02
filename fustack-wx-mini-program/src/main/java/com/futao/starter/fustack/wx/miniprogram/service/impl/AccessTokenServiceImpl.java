package com.futao.starter.fustack.wx.miniprogram.service.impl;

import com.alibaba.fastjson.JSON;
import com.futao.starter.fustack.consts.Consts;
import com.futao.starter.fustack.consts.RedisKeyConsts;
import com.futao.starter.fustack.wx.miniprogram.autoconfiguration.WxMiniProgramConfig;
import com.futao.starter.fustack.wx.miniprogram.autoconfiguration.WxMiniProgramProperties;
import com.futao.starter.fustack.wx.miniprogram.model.resuslt.AccessToken;
import com.futao.starter.fustack.wx.miniprogram.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * 微信小程序AccessToken
 *
 * @author futao
 * @date 2020/10/29
 */
@Slf4j
@Service
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private WxMiniProgramProperties wxMiniProgramProperties;

    /**
     * 获取token
     *
     * @return token
     */
    @Override
    public String get() {
        String redisAccessToken = redisTemplate.opsForValue().get(RedisKeyConsts.WxMiniProgram.WX_ACCESS_TOKEN);
        if (StringUtils.isBlank(redisAccessToken)) {
            //无缓存
            String url = UriComponentsBuilder
                    .fromHttpUrl(Consts.WxMiniProgram.WX_API_DOMAIN + "/cgi-bin/token")
                    .queryParam("grant_type", "client_credential")
                    .queryParam("appid", wxMiniProgramProperties.getAppId())
                    .queryParam("secret", wxMiniProgramProperties.getAppSecret())
                    .build()
                    .encode()
                    .toString();
            ResponseEntity<AccessToken> accessTokenResponseEntity = WxMiniProgramConfig.REST_TEMPLATE.getForEntity(url, AccessToken.class);
            AccessToken accessToken = accessTokenResponseEntity.getBody();
            if (log.isDebugEnabled()) {
                log.debug("wx result:{}", JSON.toJSONString(accessToken));
            }
            String token = accessToken.getAccessToken();
            redisTemplate.opsForValue().set(RedisKeyConsts.WxMiniProgram.WX_ACCESS_TOKEN, token, accessToken.getExpiresIn() - 5, TimeUnit.SECONDS);
            return token;
        } else {
            // 缓存命中
            log.info("cache hint");
            return redisAccessToken;
        }
    }
}
