package com.xw.io.springboot.servlet.stack.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by xiaowei.liu on 17/11/2017.
 */
public class Person {
    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String location;

    @Setter
    @Getter
    private String name;
}
