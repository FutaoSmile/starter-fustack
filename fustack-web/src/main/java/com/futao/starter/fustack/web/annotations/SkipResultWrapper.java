package com.futao.starter.fustack.web.annotations;

import java.lang.annotation.*;

/**
 * 接口返回值不需要进行封装
 *
 * @author futao
 * @date 2020/11/5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SkipResultWrapper {
}
