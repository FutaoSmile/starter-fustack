package com.futao.starter.fustack.freemarker.methods;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * 自定义Freemarker方法-LocalDateTime格式化
 * http://freemarker.foofun.cn/pgui_datamodel_method.html
 * 使用：
 * 方式1：
 * 在modelAndView中加入该对象
 *
 * @author ft
 * @date 2021/1/13
 */
public class LocalDateTimeFormatterMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (!(arguments.size() == 2 || arguments.size() == 3)) {
            throw new RuntimeException("参数个数不正确");
        }
        LocalDateTime localDateTime = (LocalDateTime) arguments.get(0);
        String formatter = (String) arguments.get(1);
        String timeZone = (String) arguments.get(2);
        return localDateTime.format(DateTimeFormatter.ofPattern(formatter, Locale.CHINA));
    }
}
