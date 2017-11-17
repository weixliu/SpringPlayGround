package com.xw.io.springboot;

import com.xw.io.springboot.configuration.PersonConfiguration;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by xiaowei.liu on 10/11/2017.
 */
@Component
@Slf4j
public class CustomApplicationRunner implements ApplicationRunner {
    @Autowired
    private PersonConfiguration person;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("=========================== CustomApplicationRunner ===========================");
        System.out.println(person.getInfo().size());
        log.trace("I want to see trace color, must be Green");
        log.debug("I want to see debug color, must be Green");
        log.info("I want to see info color, must be Green");
        log.warn("I want to see warn color, must be Yellow");
        log.error("I want to see error color, must be Red");
    }
}
