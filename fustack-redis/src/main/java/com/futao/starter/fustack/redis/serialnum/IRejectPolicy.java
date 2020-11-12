package com.futao.starter.fustack.redis.serialnum;

/**
 * @author futao
 * @date 2020/11/12
 */
@FunctionalInterface
public interface IRejectPolicy {
    void apply(IKeyDefinition keyDefinition);
}
