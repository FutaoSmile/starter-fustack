package com.futao.starter.fustack.auth.auth;

import org.springframework.web.method.HandlerMethod;

/**
 * @author futao
 * @date 2020/11/10
 */
public interface UserAuth {

    /**
     * 检测用户权限
     *
     * @param handlerMethod 请求信息
     */
    void checkUserPermission(HandlerMethod handlerMethod);
}
