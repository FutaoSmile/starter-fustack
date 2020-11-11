package com.futao.starter.fustack.web.result;

import com.futao.starter.fustack.consts.model.RestResult;
import com.futao.starter.fustack.exceptions.ApplicationException;
import com.futao.starter.fustack.web.annotations.SkipResultWrapper;
import com.futao.starter.fustack.web.autoconfiguration.WebProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Set;

/**
 * Allows customizing the response after the execution of an {@code @ResponseBody}
 * or a {@code ResponseEntity} controller method but before the body is written
 * with an {@code HttpMessageConverter}.
 *
 * @author futao
 * @date 2020/11/5
 */
@RestControllerAdvice
@Slf4j
public class RestResultAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private WebProperties webProperties;

    /**
     * controller已经执行完毕，已经拿到了返回值，在returnType中
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.debug("-");
        Class<?> declaringClass = returnType.getDeclaringClass();
        Set<String> restSkipClassPaths = webProperties.getRestSkipClassPaths();
        if (
                returnType.hasMethodAnnotation(SkipResultWrapper.class)
                        ||
                        declaringClass.isAnnotationPresent(SkipResultWrapper.class)
                        ||
                        CollectionUtils.isNotEmpty(restSkipClassPaths) && restSkipClassPaths.contains(declaringClass.getName())
        ) {
            log.debug("skip rest wrapper");
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.debug("-");
        if (body instanceof String) {
            throw new ApplicationException("请使用SingleValueResult<String>()封装String类型返回值");
        }
        if (!(body instanceof RestResult)) {
            log.debug("return value is restResult already");
            return RestResult.success(body);
        }
        return body;
    }
}
