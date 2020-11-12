package com.futao.starter.fustack.redis.serialnum;

import io.lettuce.core.RedisException;

/**
 * @author futao
 * @date 2020/11/12
 */
public class RejectPolicy {

    public static class ThrowExceptionPolicy implements IRejectPolicy {
        @Override
        public void apply(IKeyDefinition keyDefinition) {
            throw new RedisException("流水号长度超过预设值");
        }
    }
}
