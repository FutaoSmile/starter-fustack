package com.futao.starter.fustack.demo.controller.wx.mini;

import com.futao.starter.fustack.wx.miniprogram.model.resuslt.DynamicMessageCreateResult;
import com.futao.starter.fustack.wx.miniprogram.service.AccessTokenService;
import com.futao.starter.fustack.wx.miniprogram.service.DynamicMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author futao
 * @date 2020/10/30
 */
@RequestMapping("/wx/mini")
@RestController
public class WxMiniController {

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private DynamicMessageService dynamicMessageService;

    @GetMapping("/createDynamicMessage")
    public DynamicMessageCreateResult createDynamicMessage() {
        return dynamicMessageService.createActivityId();
    }

    @GetMapping("/accToken")
    public String accToken() {
        String accToken = accessTokenService.get();
        return accToken;
    }
}
