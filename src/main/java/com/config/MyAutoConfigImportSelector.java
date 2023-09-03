package com.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "com.config.autoconfig.TomcatWebServerConfig",
                "com.config.autoconfig.DispatcherServletConfig"
        };
    }
}
