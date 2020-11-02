package com.futao.starter.fustack.wx.miniprogram.service.impl;

import com.futao.starter.fustack.consts.Consts;
import com.futao.starter.fustack.wx.miniprogram.WxMiniProgramConfig;
import com.futao.starter.fustack.wx.miniprogram.model.resuslt.DynamicMessageCreateResult;
import com.futao.starter.fustack.wx.miniprogram.service.AccessTokenService;
import com.futao.starter.fustack.wx.miniprogram.service.DynamicMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

/**
 * 动态消息
 *
 * @author futao
 * @date 2020/10/30
 */
@Service
public class DynamicMessageServiceImpl implements DynamicMessageService {

    @Autowired
    private AccessTokenService accessTokenService;

    /**
     * 创建被分享动态消息或私密消息的 activity_id
     *
     * @return
     */
    @Override
    public DynamicMessageCreateResult createActivityId() {
        String url = UriComponentsBuilder
                .fromHttpUrl(Consts.WxMiniProgram.WX_API_DOMAIN + "/cgi-bin/message/wxopen/activityid/create")
                // 手动加上请求参数accessToken
//                .queryParam("access_token", accessTokenService.get())
                .build()
                .encode()
                .toString();

        ResponseEntity<DynamicMessageCreateResult> messageCreateResultResponseEntity = WxMiniProgramConfig.REST_TEMPLATE.getForEntity(url, DynamicMessageCreateResult.class);
        DynamicMessageCreateResult createResult = messageCreateResultResponseEntity.getBody();
        return createResult;
    }
}
