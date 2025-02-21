package com.vnpt.store_it.controller;

import com.vnpt.store_it.dtos.request.CheckUserLoginRequest;
import com.vnpt.store_it.dtos.request.CreateUserRequest;
import com.vnpt.store_it.dtos.response.CheckUserLoginResponse;
import com.vnpt.store_it.model.User;
import com.vnpt.store_it.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/v1/user")
    public ResponseEntity<List<User>> getList() {
        List<User> response = userService.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/user")
    public ResponseEntity<User> create(
            @RequestBody CreateUserRequest request
    ) {
        User response = userService.create(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/user/verify")
    public ResponseEntity<CheckUserLoginResponse> checkLogin(
            @RequestBody CheckUserLoginRequest request
    ) {
        CheckUserLoginResponse response = userService.checkLogin(request);
        System.out.println("response day: " + response);
        return ResponseEntity.ok(response);
    }
}
