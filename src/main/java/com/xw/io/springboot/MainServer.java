package com.xw.io.springboot;

import com.xw.io.springboot.dao.UserInfoDao;
import com.xw.io.springboot.model.UserInfo;
import com.xw.io.springboot.service.HelloWorldService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaowei.liu on 09/11/2017.
 */
@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class MainServer {
    public static final String LOGBACK_SYSTEM = "org.springframework.boot.logging.logback.LogbackLoggingSystem";
    public static final String LOG4J2_SYSTEM = "org.springframework.boot.logging.log4j2.Log4J2LoggingSystem";
    public static final String JDK_SYSTEM = "org.springframework.boot.logging.java.JavaLoggingSystem";

    @Autowired
    @Setter
    private HelloWorldService helloWorldService;

    @Autowired
    @Setter
    private UserInfoDao userInfoDao;

    @RequestMapping("/")
    public String hello() {
        return helloWorldService.sayHelloToWorld();
    }

    @RequestMapping(value = "/userinfo", method = {RequestMethod.POST})
    public String insert(@RequestParam("user_name") String userName, @RequestParam("user_password") String userPassword, @RequestParam("user_id") int userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName(userName);
        userInfo.setUserPassword(userPassword);
        userInfoDao.create(userInfo);
        return "success";
    }

    @RequestMapping(value = "/userinfo", method = {RequestMethod.GET})
    public UserInfo read(@RequestParam("user_id") int userId) {
        return userInfoDao.read(userId).get(0);
    }

    public static void main(String ... args) {
        System.setProperty("org.springframework.boot.logging.LoggingSystem", LOGBACK_SYSTEM);
        SpringApplication application = new SpringApplicationBuilder()
                .sources(MainServer.class)
                .listeners(CustomListener.listenerFactory(ApplicationStartingEvent.class.getSimpleName()),
                        CustomListener.listenerFactory(ApplicationEnvironmentPreparedEvent.class.getSimpleName()),
                        CustomListener.listenerFactory(ApplicationPreparedEvent.class.getSimpleName()),
                        CustomListener.listenerFactory(ApplicationReadyEvent.class.getSimpleName()),
                        CustomListener.listenerFactory(ApplicationFailedEvent.class.getSimpleName()))
                .initializers()
                .build();
        application.run(args);
    }
}
