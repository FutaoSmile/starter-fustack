package com.futao.starter.fustack.tencent.cloud.shortmessage.exception;

/**
 * @author futao
 * @date 2020/11/4
 */
public class TencentCloudShortMessageException extends RuntimeException {
    public TencentCloudShortMessageException() {
    }

    public TencentCloudShortMessageException(String message) {
        super(message);
    }

    public TencentCloudShortMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public TencentCloudShortMessageException(Throwable cause) {
        super(cause);
    }

    public TencentCloudShortMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
