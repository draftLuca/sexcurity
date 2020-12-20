package com.luca.securitydemo.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security配置
 * @author qhl
 */
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * 重新配置security的用户名密码
     * @param auth
     * @throws Exception
     */
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        log.info(encode);
        auth.inMemoryAuthentication().withUser("luca").password(encode).roles("admin");
    }*/

    /**
     * 用户自定义的用户名密码，实现userDetailsService 接口
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(password());

    }

    /**
     * 配置登录  哪些路径不需要拦截
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //退出
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/logout").permitAll();
        //配置没有权限跳转的页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin() //自定义登录页面
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login") //登录访问地址路径
                .defaultSuccessUrl("/success.html").permitAll()
                //.defaultSuccessUrl("/test/index").permitAll()  //登录成功后 跳转路径
                .and().authorizeRequests()
                .antMatchers("/","/user/login")
                .permitAll() //设置哪些路径可以直接访问，不认证
                // 1 .antMatchers("/test/index").hasAuthority("admins") //设置这个路径必须有admin权限可以访问
                // 2 .antMatchers("/test/index").hasAnyAuthority("admins,manager") //同上 赋值多个
                // 3 .antMatchers("/test/index").hasRole("sale") //资源只有特定角色能够访问
                .antMatchers("/test/index").hasAnyRole("sale,manager") //4. 同上
                .anyRequest().authenticated()  //所有请求都可以访问
                .and().csrf().disable();  //关闭csr防护

    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
