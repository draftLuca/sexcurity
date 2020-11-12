package com.luca.securitydemo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

//开启注解权限
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@SpringBootApplication
@MapperScan("com.luca.securitydemo.demo.dao")
public class SercurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SercurityDemoApplication.class, args);
    }

}
