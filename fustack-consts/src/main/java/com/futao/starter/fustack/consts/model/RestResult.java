package com.futao.starter.fustack.consts.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 返回结构
 *
 * @author futao
 * @date 2020/11/5
 */
@Getter
@Setter
public class RestResult<T> {
    /**
     * 状态码
     */
    private int code;
    /**
     * 接口正常返回时的数据
     */
    private T data;
    /**
     * 接口出现异常时的提示消息
     */
    private String message;

    /**
     * 正常情况数据结构
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> success(T data) {
        RestResult<T> objectRestResult = new RestResult<>();
        objectRestResult.setCode(0);
        objectRestResult.setData(data);
        return objectRestResult;
    }

    /**
     * 异常情况数据结构
     *
     * @param message
     * @return
     */
    public static RestResult<Object> fail(String message) {
        RestResult<Object> objectRestResult = new RestResult<>();
        objectRestResult.setCode(99);
        objectRestResult.setMessage(message);
        return objectRestResult;
    }

    /**
     * 异常情况数据结构，并带上堆栈信息-测试开发环境使用
     *
     * @param message
     * @param t
     * @return
     */
    public static RestResult<StackTraceElement[]> failWithReason(String message, Throwable t) {
        RestResult<StackTraceElement[]> objectRestResult = new RestResult<>();
        objectRestResult.setCode(99);
        objectRestResult.setMessage(message);
        objectRestResult.setData(t.getStackTrace());
        return objectRestResult;
    }


}
