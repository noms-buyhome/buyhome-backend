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
