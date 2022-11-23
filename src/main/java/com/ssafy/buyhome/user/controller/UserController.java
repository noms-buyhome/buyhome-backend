package com.ssafy.buyhome.user.controller;

import com.ssafy.buyhome.user.model.dto.User;
import com.ssafy.buyhome.user.model.service.UserService;
import com.ssafy.buyhome.util.TokenProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenProvider tokenProvider;

    @GetMapping("/me")
    public ResponseEntity<?> findMe(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println("user/me call :: " + token);
        String username = tokenProvider.getUsernameFromToken(token);
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> findById(@PathVariable("userid") Integer userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @PutMapping("/{userid}")
    public ResponseEntity<?> update(@PathVariable("userid") Integer userId, @RequestBody User incomingData) {
        userService.update(userId, incomingData);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<?> delete(@PathVariable("userid") Integer userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
