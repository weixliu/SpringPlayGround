package com.xw.io.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationListener;

/**
 * Created by xiaowei.liu on 10/11/2017.
 */
public class CustomListener {
    public static ApplicationListener listenerFactory(String name) {
        switch (name) {
            case "ApplicationStartingEvent":
                return new CustomApplicationStartingEventListenser();
            case "ApplicationEnvironmentPreparedEvent":
                return new CustomApplicationEnvironmentPrepareEventLisenter();
            case "ApplicationPreparedEvent":
                return new CustomApplicationPrepareEventLisenter();
            case "ApplicationReadyEvent":
                return new CustomApplicationReadyEventLisenter();
            case "ApplicationFailedEvent":
                return new CustomApplicationFailedEventLisenter();
            default:return null;
        }
    }

    @Slf4j
    public static class CustomApplicationStartingEventListenser implements ApplicationListener<ApplicationStartingEvent> {

        @Override
        public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
            //this event was fired before log system, so only using System.out.println you can see that.
            System.out.println(applicationStartingEvent.getClass().getSimpleName() + " is starting" + "==================See Me=================");
        }
    }

    @Slf4j
    public static class CustomApplicationEnvironmentPrepareEventLisenter implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
            log.info(applicationEnvironmentPreparedEvent.getClass().getSimpleName() + " is starting" + "==================See Me=================");
        }
    }

    @Slf4j
    public static class CustomApplicationPrepareEventLisenter implements ApplicationListener<ApplicationPreparedEvent> {

        @Override
        public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
            log.info(applicationPreparedEvent.getClass().getSimpleName() + " is starting" + "==================See Me=================");
        }
    }

    @Slf4j
    public static class CustomApplicationReadyEventLisenter implements ApplicationListener<ApplicationReadyEvent> {

        @Override
        public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
            log.info(applicationReadyEvent.getClass().getSimpleName() + " is starting" + "==================See Me=================");
        }
    }

    @Slf4j
    public static class CustomApplicationFailedEventLisenter implements ApplicationListener<ApplicationFailedEvent> {

        @Override
        public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
            log.info(applicationFailedEvent.getClass().getSimpleName() + " is starting" + "==================See Me=================");
        }
    }
}
