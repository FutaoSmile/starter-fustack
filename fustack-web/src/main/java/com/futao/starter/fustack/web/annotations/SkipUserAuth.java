package com.futao.starter.fustack.web.annotations;

import java.lang.annotation.*;

/**
 * 接口不需要登录即可访问
 *
 * @author futao
 * @date 2020/11/5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SkipUserAuth {
}
