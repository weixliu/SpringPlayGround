package com.xw.io.springboot.servlet.stack;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.File;

/**
 * Created by xiaowei.liu on 17/11/2017.
 * How to using embeded tomcat and SpringMVC to create custom web application??? This is a question!!!
 * Learn SpringMVC, tomcat, Jetty.
 */
public class CustomWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //load spring web application configuration
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.scan("com.xw.io.springboot.servlet.stack.config");
        annotationConfigWebApplicationContext.refresh();

        //create DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);

        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispacher", dispatcherServlet);
        dynamic.setLoadOnStartup(1);
        dynamic.addMapping("/app/*");


    }

    public static void main(String... args) throws Exception {
        String webappDirLocation = "";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
        System.out.println(new File(webappDirLocation).getAbsoluteFile());

        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work

        tomcat.start();
        tomcat.getServer().await();
    }
}
