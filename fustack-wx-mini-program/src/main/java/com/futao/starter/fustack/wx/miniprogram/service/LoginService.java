package com.futao.starter.fustack.wx.miniprogram.service;

import com.futao.starter.fustack.wx.miniprogram.model.resuslt.AuthCode;

/**
 * @author futao
 * @date 2020/10/29
 */
public interface LoginService {
    /**
     * 通过小程序传过来的临时票据code获取该用户的openId
     * <p>
     * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
     *
     * @param code 临时票据
     * @return
     */
    AuthCode getOpenIdByCode(String code);
}
