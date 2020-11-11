package com.futao.starter.fustack.auth.jwt;

import com.futao.starter.fustack.auth.autoconfiguration.AuthProperties;
import com.futao.starter.fustack.consts.Constants;
import com.futao.starter.fustack.consts.SystemErrorMessages;
import com.futao.starter.fustack.exceptions.LogicException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author futao
 * @date 2020/11/11
 */
@Component
public class JwtUtil {

    private final AuthProperties authProperties;

    private final Key key;

    @Autowired
    public JwtUtil(AuthProperties authProperties) {
        this.authProperties = authProperties;
        this.key = Keys.hmacShaKeyFor(authProperties.getJwtSignKey().getBytes(StandardCharsets.UTF_8));

    }

    /**
     * 生成token
     *
     * @param userId
     * @return
     */
    public String encode(Long userId) {
        HashMap<String, Object> jwtBody = new HashMap<>();
        jwtBody.put(Constants.Auth.EXPIRE,
                DateTimeFormatter.ofPattern(Constants.Time.DATE_TIME_COMPLETE)
                        .format(LocalDateTime.now(ZoneOffset.ofHours(8))
                                .plus(authProperties.getJwtDuration())));
        jwtBody.put(Constants.Auth.USER_ID, userId);

        return Constants.Auth.TOKEN_PREFIX + Jwts.builder()
                .setClaims(jwtBody)
                .signWith(key)
                .compact();
    }

    /**
     * token解码
     *
     * @param token
     * @return
     */
    public Map<String, Object> decode(String token) {
        if (StringUtils.isBlank(token)) {
            throw new LogicException(SystemErrorMessages.NOT_LOGIN);
        }
        token = token.replace(Constants.Auth.TOKEN_PREFIX, "");
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        Long userId = body.get(Constants.Auth.USER_ID, Long.class);
        LocalDateTime exp = LocalDateTime.parse(body.get(Constants.Auth.EXPIRE, String.class), DateTimeFormatter.ofPattern(Constants.Time.DATE_TIME_COMPLETE));
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(Constants.Auth.USER_ID, userId);
        hashMap.put(Constants.Auth.EXPIRE, exp);
        return hashMap;
    }
}
