package com.helloboot.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// 인터페이스 없이 CGLIB 사용
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestContext {

    private String requestId = UUID.randomUUID().toString();
    private long startTime = System.currentTimeMillis();
    private Map<String, Object> attributes = new HashMap<>();

    public RequestContext() {
        System.out.println("새로운 Request 컨텍스트 생성: " + requestId);
    }

    public String getRequestId() { return requestId; }
    public long getStartTime() { return startTime; }

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }
}
