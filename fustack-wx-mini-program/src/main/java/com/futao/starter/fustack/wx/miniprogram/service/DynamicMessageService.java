package com.futao.starter.fustack.wx.miniprogram.service;

import com.futao.starter.fustack.wx.miniprogram.model.resuslt.DynamicMessageCreateResult;

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
}
