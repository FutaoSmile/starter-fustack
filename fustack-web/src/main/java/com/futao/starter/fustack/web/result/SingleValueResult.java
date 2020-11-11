package com.futao.starter.fustack.web.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/11/11
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SingleValueResult<T> {
    private T value;

    public static SingleValueResult<String> string(String result) {
        return new SingleValueResult<>(result);
    }
}
