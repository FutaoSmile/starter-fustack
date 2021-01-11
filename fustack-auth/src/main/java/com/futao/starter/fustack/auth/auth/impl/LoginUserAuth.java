package com.futao.starter.fustack.auth.auth.impl;

import com.futao.starter.fustack.auth.auth.UserAuth;
import com.futao.starter.fustack.auth.autoconfiguration.AuthProperties;
import com.futao.starter.fustack.auth.jwt.JwtUtil;
import com.futao.starter.fustack.auth.threadlocals.CurrentUserId;
import com.futao.starter.fustack.consts.Constants;
import com.futao.starter.fustack.consts.SystemErrorMessages;
import com.futao.starter.fustack.exceptions.LogicException;
import com.futao.starter.fustack.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

/**
 * @author futao
 * @date 2020/11/10
 */
@Slf4j
public class LoginUserAuth implements UserAuth {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthProperties authProperties;

    @Override
    public void checkUserPermission(HandlerMethod handlerMethod) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String authorizationHeader = request.getHeader("Authorization");
        if (StringUtils.isBlank(authorizationHeader) || !authorizationHeader.startsWith(Constants.Auth.TOKEN_PREFIX)) {
            notAuth();
        } else {
            Map<String, Object> userMap = jwtUtil.decode(authorizationHeader);
            Long userId = (Long) userMap.get(Constants.Auth.USER_ID);
            LocalDateTime expireDateTime = (LocalDateTime) userMap.get(Constants.Auth.EXPIRE);
            if (expireDateTime.isBefore(LocalDateTime.now(ZoneOffset.ofHours(8)))) {
                notAuth();
            }
            CurrentUserId.set(userId);
        }
    }

    /**
     * 提示或转发
     */
    private void notAuth() {
        HttpServletResponse response = WebUtil.servletRequestAttributes().getResponse();
        HttpServletRequest request = WebUtil.servletRequestAttributes().getRequest();
        if (authProperties.isSeparationOfFrontAndRearEnds()) {
            throw new LogicException(SystemErrorMessages.NOT_LOGIN);
        } else {
            try {
                response.sendRedirect(request.getContextPath() + authProperties.getNoAuth401Page());
            } catch (IOException e) {
                log.error("重定向至登录页失败", e);
            }
        }
    }
}
