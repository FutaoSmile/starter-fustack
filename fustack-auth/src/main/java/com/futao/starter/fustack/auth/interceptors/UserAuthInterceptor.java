package com.futao.starter.fustack.auth.interceptors;

import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import com.futao.starter.fustack.auth.auth.UserAuth;
import com.futao.starter.fustack.auth.autoconfiguration.AuthProperties;
import com.futao.starter.fustack.auth.threadlocals.CurrentUserId;
import com.futao.starter.fustack.util.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户权限拦截器
 *
 * @author futao
 * @date 2020/11/10
 */
@Slf4j
public class UserAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private UserAuth userAuth;

    @Autowired
    private AuthProperties authProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.getMethod().isAnnotationPresent(SkipUserAuth.class)
                    || handlerMethod.getMethod().getDeclaringClass().isAnnotationPresent(SkipUserAuth.class)
                    || (authProperties.getSkipAuthClassList() != null && authProperties.getSkipAuthClassList().contains(handlerMethod.getMethod().getDeclaringClass().getName()))
                    || (authProperties.getSkipAuthClassMethodList() != null && authProperties.getSkipAuthClassMethodList().contains(handlerMethod.getMethod().getName()))
                    || CollectionUtils.isNotEmpty(authProperties.getSkipAuthPathList()) && authProperties.getSkipAuthPathList().contains(WebUtils.servletRequestAttributes().getRequest().getRequestURI())
            ) {
                log.debug("skip user auth interceptor");
                return true;
            }
            //需要权限检查
            userAuth.checkUserPermission(handlerMethod);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CurrentUserId.remove();
        log.info("清除线程缓存");
    }
}
