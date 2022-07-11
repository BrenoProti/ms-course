package com.proti.hrauth.service;

import com.proti.hrauth.client.UserClient;
import com.proti.hrauth.model.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserClient client;

    public User findByEmail(String email) {
        try {
            return client.findByEmail(email).getBody();
        } catch (Exception e) {
            log.error("Erro ao tentar comunicar com a API de usário: ".concat(e.getMessage()));
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = client.findByEmail(username).getBody();
        if (user == null) {
            log.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        log.info("Email found: " + username);
        return user;
    }
}
