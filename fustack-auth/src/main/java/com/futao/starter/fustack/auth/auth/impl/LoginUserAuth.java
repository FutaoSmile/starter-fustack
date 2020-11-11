package com.futao.starter.fustack.auth.auth.impl;

import com.futao.starter.fustack.auth.auth.UserAuth;
import com.futao.starter.fustack.auth.jwt.JwtUtil;
import com.futao.starter.fustack.auth.threadlocals.CurrentUserId;
import com.futao.starter.fustack.consts.Constants;
import com.futao.starter.fustack.consts.SystemErrorMessages;
import com.futao.starter.fustack.exceptions.LogicException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

/**
 * @author futao
 * @date 2020/11/10
 */
public class LoginUserAuth implements UserAuth {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void checkUserPermission(HandlerMethod handlerMethod) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String authorizationHeader = request.getHeader("Authorization");
        if (StringUtils.isBlank(authorizationHeader) || !authorizationHeader.startsWith(Constants.Auth.TOKEN_PREFIX)) {
            throw new LogicException(SystemErrorMessages.NOT_LOGIN);
        } else {
            Map<String, Object> userMap = jwtUtil.decode(authorizationHeader);
            Long userId = (Long) userMap.get(Constants.Auth.USER_ID);
            LocalDateTime expireDateTime = (LocalDateTime) userMap.get(Constants.Auth.EXPIRE);
            if (expireDateTime.isBefore(LocalDateTime.now(ZoneOffset.ofHours(8)))) {
                throw new LogicException(SystemErrorMessages.NOT_LOGIN);
            }
            CurrentUserId.set(userId);
        }
    }
}
