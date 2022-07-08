package com.proti.hrauth.service;

import com.proti.hrauth.client.UserClient;
import com.proti.hrauth.model.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserClient client;

    public User findByEmail(String email) {
        try {
            return client.findByEmail(email).getBody();
        } catch (Exception e) {
            log.error("Erro ao tentar comunicar com a API de usário: ".concat(e.getMessage()));
            throw new RuntimeException(e.getMessage());
        }
    }
}
