package com.futao.starter.fustack.auth.auth.impl;

import com.futao.starter.fustack.auth.auth.UserAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;

/**
 * 默认的用户权限校验
 *
 * @author futao
 * @date 2020/11/10
 */
@Slf4j
public class DefaultUserAuth implements UserAuth {

    @Override
    public void checkUserPermission(HandlerMethod handlerMethod) {
        log.debug("default user auth permission check pass.");
    }
}
