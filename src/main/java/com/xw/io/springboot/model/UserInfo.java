package com.xw.io.springboot.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by xiaowei.liu on 13/11/2017.
 */
public class UserInfo {

    @Setter
    @Getter
    private int userId;

    @Setter
    @Getter
    private String userName;

    @Setter
    @Getter
    private String userPassword;
}
