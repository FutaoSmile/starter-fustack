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
public class SubscribeMessage {
    @JsonProperty("touser")
    private String toUser;

    @JsonProperty("template_id")
    private String templateId;
    private String page;
    private JSONObject data;
    /**
     * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
     */
    @JsonProperty("miniprogram_state")
    private String miniProgramState;
    private String lang = "zh_CN";
}
