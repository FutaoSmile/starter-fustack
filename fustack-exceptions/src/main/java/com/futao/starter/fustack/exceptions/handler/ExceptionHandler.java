package com.futao.starter.fustack.exceptions.handler;

import com.futao.starter.fustack.exceptions.ApplicationException;
import com.futao.starter.fustack.exceptions.LogicException;
import com.futao.starter.fustack.web.result.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author futao
 * @date 2020/11/10
 */
@RestControllerAdvice
public class ExceptionHandler {

    @Autowired
    private Environment environment;

    @org.springframework.web.bind.annotation.ExceptionHandler(LogicException.class)
    public RestResult<? extends Object> logicExceptionHandler(LogicException e) {
        if (environment.acceptsProfiles(Profiles.of("local", "dev"))) {
            return RestResult.failWithReason(e.getMessage(), e);
        }
        return RestResult.fail(e.getMessage());
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(ApplicationException.class)
    public RestResult<? extends Object> applicationExceptionHandler(ApplicationException e) {
        if (environment.acceptsProfiles(Profiles.of("local", "dev"))) {
            return RestResult.failWithReason("系统繁忙，请稍后再试", e);
        }
        return RestResult.fail("系统繁忙，请稍后再试");
    }


}
