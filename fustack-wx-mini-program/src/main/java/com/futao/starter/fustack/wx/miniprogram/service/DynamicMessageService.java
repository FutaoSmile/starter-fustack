package com.futao.starter.fustack.wx.miniprogram.service;

import com.futao.starter.fustack.wx.miniprogram.model.WxBaseResult;
import com.futao.starter.fustack.wx.miniprogram.model.request.Message;
import com.futao.starter.fustack.wx.miniprogram.model.request.SubscribeMessage;
import com.futao.starter.fustack.wx.miniprogram.model.resuslt.DynamicMessageCreateResult;
import org.springframework.http.ResponseEntity;

/**
 * @author futao
 * @date 2020/10/30
 */
public interface DynamicMessageService {
    /**
     * 创建被分享动态消息或私密消息的 activity_id
     * @return
     */
    DynamicMessageCreateResult createActivityId();

    /**
     * 下发小程序和公众号统一的服务消息
     * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/uniform-message/uniformMessage.send.html
     *
     * @param message
     * @return
     */
    ResponseEntity<WxBaseResult> sendUniformMessage(Message message);

    /**
     * 发送微信小程序订阅消息
     *
     * @param message
     * @return
     */
    WxBaseResult sendSubscribeMessage(SubscribeMessage message);
}
