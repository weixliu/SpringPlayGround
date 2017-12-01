package com.xw.io.springboot;

import com.xw.io.springboot.configuration.PropertiesConfiguration;
import com.xw.io.springboot.service.SS;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import static org.springframework.boot.logging.LoggingApplicationListener.CONSOLE_LOG_PATTERN;

/**
 * Created by xiaowei.liu on 10/11/2017.
 */
@Component
public class CustomCommandLineRunner implements CommandLineRunner {
    @Autowired
    @Setter
    private Environment environment;

    @Autowired
    @Setter
    private PropertiesConfiguration propertiesConfiguration;

    @Autowired
    @Setter
    private SS ss;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("=========================== CustomCommandLineRunner ===========================");
        System.out.println("=========================== " + environment.getProperty("local.server.port") + " ===============================");
        System.out.println("=========================== " + environment.getProperty("logging.pattern.console") + " ===============================");
        System.out.println("=========================== " + propertiesConfiguration.getEasyStr() + " ===============================");
        System.out.println("=========================== " + CONSOLE_LOG_PATTERN + " ===============================");
        ss.say();
    }
}
