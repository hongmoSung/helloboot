package com.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@ComponentScan
@Configuration
public class HellobootApplication {

    @Bean
    public ServletWebServerFactory webServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        // 스프링 컨테이너
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//                dispatcherServlet.setApplicationContext(this); 이걸 안해도 동작하는게 신기해야함

                WebServer webServer = serverFactory.getWebServer(servletContext ->
                        servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                                .addMapping("/*")
                );
                webServer.start();
            }
        };
        applicationContext.register(HellobootApplication.class);
        applicationContext.refresh();
    }
}
