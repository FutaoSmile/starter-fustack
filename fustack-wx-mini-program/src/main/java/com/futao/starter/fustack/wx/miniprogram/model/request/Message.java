package com.futao.starter.fustack.wx.miniprogram.model.request;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/11/2
 */
@Getter
@Setter
public class Message {

    /**
     * 用户openid，可以是小程序的openid，也可以是mp_template_msg.appid对应的公众号的openid
     */
    @JsonProperty("touser")
    private String toUser;

    /**
     * 小程序模板消息相关的信息，可以参考小程序模板消息接口; 有此节点则优先发送小程序模板消息
     */
    @JsonProperty("weapp_template_msg")
    private WeAppTemplateMsg weAppTemplateMsg;

    /**
     * 公众号模板消息相关的信息，可以参考公众号模板消息接口；有此节点并且没有weapp_template_msg节点时，发送公众号模板消息
     */
    @JsonProperty("mp_template_msg")
    private Object mpTemplateMsg;


    @Getter
    @Setter
    public static class WeAppTemplateMsg {

        /**
         * 小程序模板ID
         */
        @JsonProperty("template_id")
        private String templateId;

        /**
         * 小程序页面路径
         */
        private String page;

        /**
         * 小程序模板消息formid
         */
        @JsonProperty("form_id")
        private String formId;

        /**
         * 小程序模板数据
         */
        private JSONObject data;

        /**
         * 小程序模板放大关键词
         */
        @JsonProperty("emphasis_keyword")
        private String emphasisKeyword;
    }
}
