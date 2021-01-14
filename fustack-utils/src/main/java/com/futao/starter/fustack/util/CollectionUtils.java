package com.futao.starter.fustack.util;

import java.util.Collection;
import java.util.HashMap;

/**
 * 集合工具类
 *
 * @author ft
 * @date 2021/1/14
 */
public class CollectionUtils {
    public static int initSize(int elementCount) {
        // hashmap负载因子默认为0.75，为什么要加1还不清楚
        return elementCount == 0 ? 0 : elementCount / 3 * 4 + 1;
    }

    public static int initSize(Collection collection) {
        return CollectionUtils.initSize(collection == null ? 0 : collection.size());
    }

    private CollectionUtils() {
    }

    /**
     * 验证hashMap初始值的设置问题:
     * 如果将容量设置为存储的元素数量，将可能导致扩容！！！
     *
     * @param args
     */
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>(4);
        for (int i = 0; i < 100; i++) {
            hashMap.put(String.valueOf(i), i);
            //String.format("%s,%s",hashMap.capacity(),hashMap.size)
        }
    }
}
