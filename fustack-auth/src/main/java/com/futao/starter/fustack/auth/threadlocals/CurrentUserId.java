package com.futao.starter.fustack.auth.threadlocals;

/**
 * 保存当前登录的用户的ID
 *
 * @author futao
 * @date 2020/11/10
 */
public class CurrentUserId {
    private static final ThreadLocal<Long> CUR_USER_ID = new ThreadLocal<>();

    public static Long get() {
        return CUR_USER_ID.get();
    }

    public static void set(Long userId) {
        CUR_USER_ID.set(userId);
    }

    public static void remove() {
        CUR_USER_ID.remove();
    }
}
