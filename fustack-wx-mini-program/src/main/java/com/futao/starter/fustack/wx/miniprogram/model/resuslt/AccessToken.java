package com.futao.starter.fustack.wx.miniprogram.model.resuslt;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.futao.starter.fustack.wx.miniprogram.model.WxBaseResult;
import lombok.Getter;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/10/29
 */
@Getter
@Setter
public class AccessToken extends WxBaseResult {

    @JsonAlias("access_token")
    private String accessToken;

    @JsonAlias("expires_in")
    private int expiresIn;

}
