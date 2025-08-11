package com.helloboot.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class UserPreferences {

    private String theme = "light";
    private String language = "ko";
    private List<String> favorites = new ArrayList<>();

    // Getters and Setters
    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public List<String> getFavorites() { return favorites; }
    public void addFavorite(String item) { this.favorites.add(item); }

    @PostConstruct
    public void init() {
        System.out.println("새로운 사용자 세션 생성: " + this.hashCode());
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("사용자 세션 정리: " + this.hashCode());
    }
}