package com.ymsli.bank.config;

import com.ymsli.bank.user.Role;
import com.ymsli.bank.user.User;
import com.ymsli.bank.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.findByUsername("manager1").isEmpty()) {
                User manager = new User(
                        "manager1",
                        passwordEncoder.encode("manager123"),
                        Role.MANAGER
                );
                userRepository.save(manager);
            }

            if (userRepository.findByUsername("clerk1").isEmpty()) {
                User clerk = new User(
                        "clerk1",
                        passwordEncoder.encode("clerk123"),
                        Role.CLERK
                );
                userRepository.save(clerk);
            }
        };
    }
}
