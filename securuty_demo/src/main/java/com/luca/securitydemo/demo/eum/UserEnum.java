package com.luca.securitydemo.demo.eum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserEnum {

    TOM("tom","123456"),
    LUCA("luca","123456");

    private final String name;
    private final String password;


}
