package com.futao.starter.fustack.consts;

/**
 * @author futao
 * @date 2020/10/29
 */
public class RedisKeyConsts {

    public static final String SEPARATOR = ":";

    public static class WxMiniProgram {
        //微信accessToken
        public static final String WX_ACCESS_TOKEN = Constants.System.FRAMEWORK_BASE_NAME + SEPARATOR + Constants.WxMiniProgram.WX_MINI_PROGRAM_BASE_NAME + SEPARATOR + "accessToken";
    }
}
