package com.config;

import com.config.autoconfig.DispatcherServletConfig;
import com.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ComponentScan
@Import({TomcatWebServerConfig.class, DispatcherServletConfig.class})
public @interface MyEnableAutoConfiguration {
}
