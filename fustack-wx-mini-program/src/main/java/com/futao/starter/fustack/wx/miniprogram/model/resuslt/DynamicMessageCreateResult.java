package com.futao.starter.fustack.wx.miniprogram.model.resuslt;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.futao.starter.fustack.wx.miniprogram.model.WxBaseResult;
import lombok.Getter;
import lombok.Setter;

/**
 * 创建动态消息的返回值
 *
 * @author futao
 * @date 2020/10/30
 */
@Getter
@Setter
public class DynamicMessageCreateResult extends WxBaseResult {

    /**
     * 动态消息的 ID
     */
    @JsonAlias("activity_id")
    private String activityId;

    /**
     * activity_id 的过期时间戳。默认24小时后过期。
     */
    @JsonAlias("expiration_time")
    private String expirationTime;
}
