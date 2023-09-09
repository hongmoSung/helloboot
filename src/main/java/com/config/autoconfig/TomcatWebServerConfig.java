package com.config.autoconfig;

import com.config.MyAutoConfiguration;
import com.config.MyConditional;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@MyConditional("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory webServerFactory() {
        return new TomcatServletWebServerFactory();
    }

}
