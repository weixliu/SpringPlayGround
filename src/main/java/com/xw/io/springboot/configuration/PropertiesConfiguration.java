package com.xw.io.springboot.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * Created by xiaowei.liu on 13/11/2017.
 */
@Configuration
public class PropertiesConfiguration {
    @Getter
    @Setter
    @Value("${config.easy-str}")
    private String easyStr;

    //@Value can't support this, using @ConfigurationProperties
    private final Security security = new Security();

    public static class Security {
        @Getter
        @Setter
        private String password;
    }

    //So I have ability to add HttpMessageConverter.
    //http://www.baeldung.com/spring-httpmessageconverter-rest learn what's HttpMessageConverter.
    @Bean
    public HttpMessageConverters customConverters() {
        HttpMessageConverter<?> httpMessageConverter = new CustomHttpMessageConverter<String>();
        return new HttpMessageConverters(httpMessageConverter);
    }
}
