package com.futao.starter.fustack.redis.serialnum;

/**
 * @author futao
 * @date 2020/11/12
 */
public interface IKeyDefinition {
    /**
     * 是否显示日期时间前缀
     *
     * @return
     */
    boolean dateTimePrefix();

    /**
     * 时间前缀格式
     * 只有当dateTimePrefix()返回true时才有效
     *
     * @return
     */
    String dateTimePrefixPattern();

    /**
     * 流水号长度(日期时间不计入)
     *
     * @return
     */
    int length();

    /**
     * redis中这个键值的key
     *
     * @return
     */
    String redisKey();

    /**
     * 拒绝策略
     *
     * @return
     */
    IRejectPolicy rejectPolicy();

}
