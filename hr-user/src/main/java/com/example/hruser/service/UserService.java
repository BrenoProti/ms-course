package com.example.hruser.service;

import com.example.hruser.model.entity.User;
import com.example.hruser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository repository;

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
