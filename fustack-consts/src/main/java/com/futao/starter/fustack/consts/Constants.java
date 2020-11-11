package com.futao.starter.fustack.consts;

/**
 * 常量
 *
 * @author futao
 * @date 2020/10/29
 */
public class Constants {

    public static class Time {
        public static final String DATE_TIME_COMPLETE = "yyyy-MM-dd HH:mm:ss";
    }

    public static class System {
        public static final String FRAMEWORK_BASE_NAME = "fustack";
    }

    public static class WxMiniProgram {
        //微信小程序模块名
        public static final String WX_MINI_PROGRAM_BASE_NAME = "wx-mini-program";
        //微信api服务器域名
        public static final String WX_API_DOMAIN = "https://api.weixin.qq.com";
    }

    public static class TencentCloudShortMessage {
        public static final String BASE_NAME = "tencent-cloud-short-message";
    }

    public static class Web {
        public static final String BASE_NAME = "web";
    }


    public static class Auth {
        public static final String BASE_NAME = "auth";
        public static final String TOKEN_PREFIX = "Bearer ";
        public static final String USER_ID = "userId";
        public static final String EXPIRE = "expire";
    }
}
