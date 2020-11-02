package com.futao.starter.fusstack.foundation.model;

/**
 * @author futao
 * @date 2020/11/2
 */
public interface IEnum<T> {

    /**
     * 获取业务值
     *
     * @return 业务值
     */
    T getValue();

    /**
     * 获取描述
     *
     * @return 描述
     */
    String getDescription();

}
