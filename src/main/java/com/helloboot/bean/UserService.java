package com.helloboot.bean;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserPreferences userPreferences;

    public UserService(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    public void updateTheme(String theme) {
        userPreferences.setTheme(theme);
    }

    public void addToFavorites(String item) {
        userPreferences.addFavorite(item);
    }

    public UserPreferences getCurrentUserPreferences() {
        return userPreferences;
    }
}
