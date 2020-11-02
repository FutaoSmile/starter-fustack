package com.futao.starter.fustack.wx.miniprogram.exception;

/**
 * 微信小程序异常体系
 *
 * @author futao
 * @date 2020/10/29
 */
public class WxMiniProgramException extends RuntimeException {
    public WxMiniProgramException() {
    }

    public WxMiniProgramException(String message) {
        super(message);
    }

    public WxMiniProgramException(String message, Throwable cause) {
        super(message, cause);
    }

    public WxMiniProgramException(Throwable cause) {
        super(cause);
    }

    public WxMiniProgramException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
