package com.futao.starter.fusstack.foundation.user;

/**
 * @author futao
 * @date 2020/11/2
 */
public class CurrentUserId {

    private static final ThreadLocal<Long> CURRENT_USER_ID = new ThreadLocal<Long>();

    public static void set(Long userId) {
        CURRENT_USER_ID.set(userId);
    }

    public static Long get() {
        return CURRENT_USER_ID.get();
    }
}
