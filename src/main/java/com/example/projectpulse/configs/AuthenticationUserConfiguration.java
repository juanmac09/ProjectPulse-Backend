package com.example.projectpulse.configs;

import com.example.projectpulse.dtos.auth.read.AuthenticatedUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationUserConfiguration {

    @Bean
    public AuthenticatedUser authenticatedUser() {
        return new AuthenticatedUser();
    }
}
