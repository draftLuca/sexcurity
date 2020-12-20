package com.luca.securitydemo.demo.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luca.securitydemo.demo.entity.User;
import com.luca.securitydemo.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2020-11-10 21:01:20
 */
@RestController
@RequestMapping("test")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @GetMapping("hello")
    public String hello() {
        return "hello security";
    }

    @GetMapping("index")
    public String index() {
        return "hello index";
    }

    @GetMapping("logout")
    public String logout() {
        return "logout";
    }
}