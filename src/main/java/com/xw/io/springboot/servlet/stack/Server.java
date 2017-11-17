package com.xw.io.springboot.servlet.stack;

import org.apache.catalina.startup.Tomcat;


/**
 * Created by xiaowei.liu on 17/11/2017.
 */
public class Server {
    public static void main(String... args) throws Exception {
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        tomcat.getHost().setAppBase(".");
        tomcat.addWebapp("/", ".");



        tomcat.start();
        tomcat.getServer().await();
    }
}
