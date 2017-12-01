package com.xw.io.springboot.service;


import lombok.Setter;

/**
 * Created by xiaowei.liu on 30/11/2017.
 */
public class SS {
    @Setter
    private int iss = 0;

    public void say() {
        System.out.println(iss);
    }
}
