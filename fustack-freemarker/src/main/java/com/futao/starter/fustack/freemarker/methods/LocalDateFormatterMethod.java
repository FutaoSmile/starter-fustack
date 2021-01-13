package com.futao.starter.fustack.freemarker.methods;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * Freemarker方法-LocalDate格式化
 *
 * @author ft
 * @date 2021/1/13
 */
public class LocalDateFormatterMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (!(arguments.size() == 2 || arguments.size() == 3)) {
            throw new RuntimeException("参数个数不正确");
        }
        LocalDate localDate = (LocalDate) arguments.get(0);
        String formatter = (String) arguments.get(1);
        String timeZone = (String) arguments.get(2);
        return localDate.format(DateTimeFormatter.ofPattern(formatter, Locale.CHINA));
    }
}
