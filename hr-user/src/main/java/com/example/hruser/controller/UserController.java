package com.example.hruser.controller;

import com.example.hruser.model.entity.User;
import com.example.hruser.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/email")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }
}
