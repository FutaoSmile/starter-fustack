package com.futao.starter.fustack.demo.controller;

import com.futao.starter.fustack.auth.annotations.SkipUserAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author futao
 * @date 2020/11/10
 */
@RequestMapping("/auth")
@RestController
public class AuthController {

    @GetMapping
    public String user() {
        return "Good weather";
    }

}
