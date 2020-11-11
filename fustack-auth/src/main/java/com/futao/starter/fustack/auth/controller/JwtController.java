package com.futao.starter.fustack.auth.controller;

import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import com.futao.starter.fustack.auth.jwt.JwtUtil;
import com.futao.starter.fustack.web.result.SingleValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author futao
 * @date 2020/11/11
 */
@SkipUserAuth
@RequestMapping("/fustack/auth/jwt")
@RestController
public class JwtController {
    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/encode/{userId}")
    public SingleValueResult<String> encode(@PathVariable("userId") Long userId) {
        return new SingleValueResult<String>(jwtUtil.encode(userId));
    }

    @GetMapping("/decode/{jwt}")
    public Map<String, Object> decode(@PathVariable("jwt") String jwt) {
        return jwtUtil.decode(jwt);
    }
}
