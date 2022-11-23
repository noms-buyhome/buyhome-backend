package com.ssafy.buyhome.user.controller;

import com.ssafy.buyhome.user.model.dto.Token;
import com.ssafy.buyhome.user.model.dto.User;
import com.ssafy.buyhome.user.model.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final Map<String, AuthService> authServiceMap;

    @GetMapping("/login")
    public ResponseEntity<Token> kakaoLogin(@RequestParam("code") String code, @RequestParam("type") String type) {
        Token token = authServiceMap.get(type + "AuthService").login(code);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<Token> generalLogin(@RequestBody Map<String, String> login) {
        Token token = authServiceMap.get("generalAuthService").login(login.get("username"), login.get("password"));
        return ResponseEntity.ok(token);
    }

    @PostMapping("/regist")
    public ResponseEntity<?> register(@RequestBody User user) {
        authServiceMap.get("generalAuthService").register(user);
        return ResponseEntity.ok().build();
    }
}
