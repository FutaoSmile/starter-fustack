package com.futao.starter.fustack.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author ft
 * @date 2021/1/13
 */
public class TimeUtil {
    public static LocalDate currentLocalDate() {
        return LocalDate.now(ZoneOffset.ofHours(8));
    }

    public static LocalDateTime currentLocalDateTime() {
        return LocalDateTime.now(ZoneOffset.ofHours(8));
    }
}
