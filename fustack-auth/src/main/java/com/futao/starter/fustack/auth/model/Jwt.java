package com.futao.starter.fustack.auth.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futao.starter.fustack.consts.Constants;
import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author futao
 * @date 2020/11/11
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Jwt {

    private Long userId;
    @DateTimeFormat(pattern = Constants.Time.DATE_TIME_COMPLETE)
    @JsonFormat(pattern = Constants.Time.DATE_TIME_COMPLETE, timezone = "GMT+8")
    private LocalDateTime exp;

    @Tolerate
    public Jwt() {
    }
}
