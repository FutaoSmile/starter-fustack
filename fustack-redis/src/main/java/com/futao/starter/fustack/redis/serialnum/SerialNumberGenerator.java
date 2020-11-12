package com.futao.starter.fustack.redis.serialnum;

import cn.hutool.core.date.DateUtil;
import com.futao.starter.fustack.consts.RedisKeyConsts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author futao
 * @date 2020/11/12
 */
@Component
public class SerialNumberGenerator {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String next(IKeyDefinition keyDefinition) {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        //now dateTime
        LocalDateTime now = LocalDateTime.now(ZoneOffset.ofHours(8));
        //时间前缀
        String dateTimeStrPrefix = "";
        if (keyDefinition.dateTimePrefix()) {
            dateTimeStrPrefix = DateTimeFormatter.ofPattern(keyDefinition.dateTimePrefixPattern()).format(now);
        }
        // key值
        String redisKey = RedisKeyConsts.Redis.PREFIX + keyDefinition.redisKey() + RedisKeyConsts.SEPARATOR + DateTimeFormatter.ofPattern("yyyyMMdd").format(now);

        Boolean lucyDog = opsForValue.setIfAbsent(redisKey, "1");
        String curNum;
        if (lucyDog != null && lucyDog) {
            // 当天第一次
            redisTemplate.expireAt(redisKey, DateUtil.endOfDay(new Date()));
            curNum = "1";
        } else {
            //不是当天第一次
            Long curVal = opsForValue.increment(redisKey);
            //执行拒绝策略
            curNum = String.valueOf(curVal);
            if (curNum.length() > keyDefinition.length()) {
                keyDefinition.rejectPolicy().apply(keyDefinition);
            }
        }
        return dateTimeStrPrefix + completeSerialNum(curNum, keyDefinition.length());
    }

    /**
     * 将序列号按照位数补充完整
     *
     * @param curNum
     * @param length
     * @return
     */
    private String completeSerialNum(String curNum, int length) {
        int curLen = curNum.length();
        if (curLen == length) {
            return curNum;
        } else {
            return StringUtils.repeat("0", length - curLen) + curNum;
        }
    }
}
