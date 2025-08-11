package com.helloboot.bean;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RequestContext requestContext; // CGLIB 프록시 주입

    public UserController(UserService userService, RequestContext requestContext) {
        this.userService = userService;
        this.requestContext = requestContext;
    }

    @RequestMapping("/profile")
    public String getUserProfile() {
        requestContext.setAttribute("action", "getUserProfile");
        return "requestId " + requestContext.getRequestId();
    }

    @GetMapping("/theme")
    public ResponseEntity<String> setTheme(@RequestParam String theme) {
        userService.updateTheme(theme);
        return ResponseEntity.ok("테마가 " + theme + "으로 변경되었습니다.");
    }

    @GetMapping("/favorites")
    public ResponseEntity<String> addFavorite(@RequestParam String item) {
        userService.addToFavorites(item);
        return ResponseEntity.ok(item + "이(가) 즐겨찾기에 추가되었습니다.");
    }

    @GetMapping("/preferences")
    public UserPreferencesDto getPreferences() {
        UserPreferences currentUserPreferences = userService.getCurrentUserPreferences();
        return new UserPreferencesDto(
                currentUserPreferences.getTheme(),
                currentUserPreferences.getFavorites()
        );
    }

    public static class UserPreferencesDto {

        private final String theme;
        private final List<String> favorites;

        public UserPreferencesDto(String theme, List<String> favorites) {
            this.theme = theme;
            // 방어적 복사를 통해 원본 리스트의 불변성 보장
            this.favorites = new ArrayList<>(favorites);
        }

        public String getTheme() {
            return theme;
        }

        public List<String> getFavorites() {
            return favorites;
        }
    }
}
