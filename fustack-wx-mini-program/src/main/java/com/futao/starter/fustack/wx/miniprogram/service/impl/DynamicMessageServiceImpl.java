package com.futao.starter.fustack.wx.miniprogram.service.impl;

import com.futao.starter.fustack.consts.Consts;
import com.futao.starter.fustack.wx.miniprogram.autoconfiguration.WxMiniProgramConfig;
import com.futao.starter.fustack.wx.miniprogram.model.WxBaseResult;
import com.futao.starter.fustack.wx.miniprogram.model.request.Message;
import com.futao.starter.fustack.wx.miniprogram.model.request.SubscribeMessage;
import com.futao.starter.fustack.wx.miniprogram.model.resuslt.DynamicMessageCreateResult;
import com.futao.starter.fustack.wx.miniprogram.service.AccessTokenService;
import com.futao.starter.fustack.wx.miniprogram.service.DynamicMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

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

    /**
     * 下发小程序和公众号统一的服务消息
     * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/uniform-message/uniformMessage.send.html
     *
     * @param message
     * @return
     * @deprecated 微信已启用, 使用sendSubscribeMessage
     */
    @Deprecated
    @Override
    public ResponseEntity<WxBaseResult> sendUniformMessage(Message message) {
        String url = UriComponentsBuilder.fromHttpUrl(Consts.WxMiniProgram.WX_API_DOMAIN + "/cgi-bin/message/wxopen/template/uniform_send")
                .build()
                .encode()
                .toString();
        return WxMiniProgramConfig.REST_TEMPLATE.postForEntity(url, message, WxBaseResult.class);
    }

    /**
     * 发送微信小程序订阅消息
     * 注意: 用户通过了几次发送请求，就能发几条消息
     *
     * @param message
     * @return
     */
    @Override
    public WxBaseResult sendSubscribeMessage(SubscribeMessage message) {
        String url = UriComponentsBuilder.fromHttpUrl(Consts.WxMiniProgram.WX_API_DOMAIN + "/cgi-bin/message/subscribe/send")
                .build()
                .encode()
                .toString();
        return WxMiniProgramConfig.REST_TEMPLATE.postForEntity(url, message, WxBaseResult.class).getBody();
    }
}
