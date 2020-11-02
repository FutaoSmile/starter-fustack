package com.futao.starter.fustack.wx.miniprogram.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * 微信小程序返回值基类
 *
 * @author futao
 * @date 2020/10/29
 */
@Getter
@Setter
public class WxBaseResult {

    @JsonAlias("errmsg")
    private String errMsg;

    @JsonAlias("errcode")
    private int errCode;

}
