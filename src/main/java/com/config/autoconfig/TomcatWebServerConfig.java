package com.config.autoconfig;

import com.config.MyAutoConfiguration;
import com.config.MyConditional;
import com.config.MyEnableConfigurationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@MyConditional("org.apache.catalina.startup.Tomcat")
@MyEnableConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory webServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(properties.getPort());
        factory.setContextPath(properties.getContextPath());
        return factory;
    }

}
