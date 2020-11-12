package com.luca.securitydemo.demo.controller;

import com.luca.securitydemo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("annotation")
public class AnnotationController {

    @Autowired
    UserService userService;

    //必须有sqle || maneger这个角色才能访问
    @GetMapping("secured")
    @Secured({"ROLE_sale","ROLE_manager"})
    public String test1() {
        return "secured";
    }

    //在方法之前认证 必须有admin权限
    @GetMapping("preauthorize")
    @PreAuthorize("hasAuthority('admin')")
    //对入参过滤
    @PreFilter("filterObject.username=='admin'")
    public String test2() {
        return "preauthorize";
    }

    //在方法之后校验 必须有admin权限
    @GetMapping("postauthorize")
    @PostAuthorize("hasAuthority('admin')")
    //对返回参数过滤
    @PostFilter("filterObject.username=='admin'")
    public String test3() {
        return "postauthorize";
    }
}
