package com.helloboot.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SingletonCounter {
    private int count = 0;

    public synchronized int increment() {
        return ++count;
    }

    public int getCount() {
        return count;
    }
}
