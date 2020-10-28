package com.futao.starter.fustack;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author futao
 * @date 2020/10/28
 */
@EnableSwagger2Doc
@SpringBootApplication
public class StarterFustackApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterFustackApplication.class, args);
    }

}
