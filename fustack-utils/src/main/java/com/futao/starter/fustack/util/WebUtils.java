package com.futao.starter.fustack.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author ft
 * @date 2021/1/11
 */
public class WebUtils {

    private WebUtils() {
    }

    public static ServletRequestAttributes servletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    }


}
