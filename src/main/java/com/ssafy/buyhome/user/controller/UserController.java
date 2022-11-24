package com.ssafy.buyhome.user.controller;

import com.ssafy.buyhome.user.model.dto.User;
import com.ssafy.buyhome.user.model.exception.UserNotAllowedException;
import com.ssafy.buyhome.user.model.service.UserService;
import com.ssafy.buyhome.util.RequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.ssafy.buyhome.util.RequestUtil.getUsernameFromRequest;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<?> findMe(HttpServletRequest request) {
        String username = getUsernameFromRequest(request);
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> findById(@PathVariable("userid") Integer userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @PutMapping("/{userid}")
    public ResponseEntity<?> update(@PathVariable("userid") Integer userId, @RequestBody User incomingData, HttpServletRequest request) {
        String requestedUsername = getUsernameFromRequest(request);
        if (!requestedUsername.equals(incomingData.getUsername())) throw new UserNotAllowedException();

        userService.update(userId, incomingData);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<?> delete(@PathVariable("userid") Integer userId, HttpServletRequest request) {
        User user = userService.findById(userId);
        String requestedUsername = getUsernameFromRequest(request);
        if (!requestedUsername.equals(user.getUsername())) throw new UserNotAllowedException();

        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
