package com.xw.io.springboot.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * Created by xiaowei.liu on 10/11/2017.
 */
@PropertySource({"classpath:configuration.properties"})
@ConfigurationProperties(prefix = "my")
@Configuration
public class PersonConfiguration {
    @Setter
    @Getter
    private Map<String, String> info;
}
