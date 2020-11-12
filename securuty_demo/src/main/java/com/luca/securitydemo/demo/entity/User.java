package com.luca.securitydemo.demo.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2020-11-10 21:01:20
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
    
    private Long id;
    //用户名
    private String username;
    //密码，加密存储
    private String password;
    //注册手机号
    private String phone;
    //创建时间
    private Date created;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }