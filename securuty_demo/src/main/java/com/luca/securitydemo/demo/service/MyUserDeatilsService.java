package com.luca.securitydemo.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.luca.securitydemo.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailService")
public class MyUserDeatilsService implements UserDetailsService {

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //权限不支持null
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("manager,admin");
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,s);
        User user = userService.getOne(wrapper);
        if (null != user) {
            return new org.springframework.security.core.userdetails.User(s,new BCryptPasswordEncoder().encode(user.getPassword()),auths);
        } else {
            throw new UsernameNotFoundException(s);
        }
    }

}
