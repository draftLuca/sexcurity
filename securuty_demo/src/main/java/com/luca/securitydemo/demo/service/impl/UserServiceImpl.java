package com.luca.securitydemo.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luca.securitydemo.demo.dao.UserDao;
import com.luca.securitydemo.demo.entity.User;
import com.luca.securitydemo.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2020-11-10 21:01:20
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}