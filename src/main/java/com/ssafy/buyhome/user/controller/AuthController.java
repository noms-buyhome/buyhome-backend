package com.ssafy.buyhome.user.controller;

import com.ssafy.buyhome.user.model.dto.Token;
import com.ssafy.buyhome.user.model.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public ResponseEntity<Token> kakaoLogin(@RequestParam String code) {
        System.out.println("code :: " + code);
        Token token = authService.getKakaoToken(code);
        System.out.println("token ::" + token);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
