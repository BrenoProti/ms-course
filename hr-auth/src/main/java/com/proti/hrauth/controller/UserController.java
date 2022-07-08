package com.proti.hrauth.controller;

import com.proti.hrauth.model.entity.User;
import com.proti.hrauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @GetMapping("/email")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }
}
