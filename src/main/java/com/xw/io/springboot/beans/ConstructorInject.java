package com.xw.io.springboot.beans;

/**
 * Created by xiaowei.liu on 04/12/2017.
 */
public class ConstructorInject {
    private String name;

    public ConstructorInject(String name) {
        this.name = name;
    }

    public ConstructorInject() {
        this.name = "Default Name";
    }

    public void sayName() {
        System.out.println("Hello " + name);
    }
}
