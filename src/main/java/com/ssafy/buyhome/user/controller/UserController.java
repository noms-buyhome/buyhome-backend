package com.ssafy.buyhome.user.controller;

import com.ssafy.buyhome.user.model.dto.User;
import com.ssafy.buyhome.user.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> findById(@PathVariable("userid") Integer userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }
}
