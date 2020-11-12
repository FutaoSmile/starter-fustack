package com.futao.starter.fustack.redis.exceptions;

import com.futao.starter.fustack.exceptions.LogicException;

/**
 * 流水号超出范围
 *
 * @author futao
 * @date 2020/11/12
 */
public class SerialNumOutOfRangeException extends LogicException {
    public SerialNumOutOfRangeException() {
    }

    public SerialNumOutOfRangeException(String message) {
        super(message);
    }

    public SerialNumOutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerialNumOutOfRangeException(Throwable cause) {
        super(cause);
    }

    public SerialNumOutOfRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
