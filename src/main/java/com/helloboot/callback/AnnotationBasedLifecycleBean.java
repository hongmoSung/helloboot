package com.helloboot.callback;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class AnnotationBasedLifecycleBean {

    private String name = "AnnotationBean";

    public AnnotationBasedLifecycleBean() {
        System.out.println("1. " + name + " - 생성자 호출");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("2. " + name + " - @PostConstruct 초기화");
        // 의존성 주입 완료 후 실행되는 초기화 로직
        validateConfiguration();
        setupResources();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("6. " + name + " - @PreDestroy 정리");
        // 컨테이너 종료 전 실행되는 정리 로직
        releaseResources();
    }

    private void validateConfiguration() {
        // 설정 검증 로직
        System.out.println("   설정 검증 완료");
    }

    private void setupResources() {
        // 리소스 초기화
        System.out.println("   리소스 초기화 완료");
    }

    private void releaseResources() {
        // 리소스 해제
        System.out.println("   리소스 해제 완료");
    }
}