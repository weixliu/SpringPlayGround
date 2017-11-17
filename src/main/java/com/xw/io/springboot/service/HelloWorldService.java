package com.xw.io.springboot.service;

/**
 * Created by xiaowei.liu on 10/11/2017.
 */
public class HelloWorldService {
    private String name;

    public HelloWorldService(String name) {
        this.name = name;
    }

    public String sayHelloToWorld() {
        return "Hello " + name;
    }
}
