package com.config.autoconfig;

import com.config.MyAutoConfiguration;
import com.config.MyConditional;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@MyConditional("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory webServerFactory() {
        return new JettyServletWebServerFactory();
    }

}
