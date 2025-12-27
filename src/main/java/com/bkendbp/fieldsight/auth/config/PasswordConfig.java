package com.bkendbp.fieldsight.auth.config;

import jakarta.validation.constraints.Size;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public static PasswordEncoder passwordEncoder(@Size(message = "Password must contain at least 6 characters.") String password) {
        return new BCryptPasswordEncoder();
    }
}
