package com.futao.starter.fustack.tencent.cloud.shortmessage.service;

import com.futao.starter.fustack.tencent.cloud.shortmessage.model.IMessageTemplateEnum;

/**
 * @author futao
 * @date 2020/11/3
 */
public interface ShortMessageService {
    /**
     * 发送短信
     *
     * @param messageTemplateEnum 模板
     * @param templateParams      参数
     * @param phoneNumbers        手机号
     */
    void send(IMessageTemplateEnum messageTemplateEnum, String[] templateParams, String... phoneNumbers);
}
