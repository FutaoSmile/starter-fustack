package com.futao.starter.fustack.auth.auth.impl;

import com.futao.starter.fustack.auth.auth.UserAuth;
import com.futao.starter.fustack.auth.threadlocals.CurrentUserId;
import com.futao.starter.fustack.exceptions.LogicException;
import org.springframework.web.method.HandlerMethod;

/**
 * @author futao
 * @date 2020/11/10
 */
public class LoginUserAuth implements UserAuth {

    @Override
    public void checkUserPermission(HandlerMethod handlerMethod) {
        Long userId = CurrentUserId.get();
        if (userId == null) {
            throw new LogicException("您还未登录或者登录已超时，请重新登录");
        }
    }

}
