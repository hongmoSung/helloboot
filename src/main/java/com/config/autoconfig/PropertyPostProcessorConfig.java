package com.config.autoconfig;

import com.config.MyAutoConfiguration;
import com.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

    @Bean
    BeanPostProcessor propertyBeanPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyConfigurationProperties annotation =
                        AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if (annotation == null) {
                    return bean;
                }
                Map<String, Object> attributes = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = String.valueOf(attributes.get("prefix"));
                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }

}
