package com.futao.starter.fustack.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author ft
 * @date 2021/1/11
 */
public class WebUtil {

    private WebUtil() {
    }

    public static ServletRequestAttributes servletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    }


}
