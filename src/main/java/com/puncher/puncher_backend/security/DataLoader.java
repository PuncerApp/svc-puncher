package com.puncher.puncher_backend.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadUsers(
            UserRepository userRepository,
            PasswordEncoder encoder
    ) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole(Role.ADMIN);
                userRepository.save(admin);
            }

            if (userRepository.findByUsername("owner1").isEmpty()) {
                User owner = new User();
                owner.setUsername("owner1");
                owner.setPassword(encoder.encode("owner123"));
                owner.setRole(Role.OWNER);
                userRepository.save(owner);
            }
        };
    }
}
