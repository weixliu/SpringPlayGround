package com.xw.io.springboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xiaowei.liu on 10/11/2017.
 */
@Configuration
@ImportResource("classpath:beans.xml")
public class ImportXmlConfiguration {
}
