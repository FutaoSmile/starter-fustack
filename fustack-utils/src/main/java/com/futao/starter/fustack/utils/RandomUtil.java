package com.futao.starter.fustack.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

/**
 * @author futao
 * @date 2020/11/12
 */
public class RandomUtil extends RandomStringUtils {

    /**
     * 随机UUID，删除了`-`
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
