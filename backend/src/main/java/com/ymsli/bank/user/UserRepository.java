package com.ymsli.bank.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find user by username for authentication.
     */
    Optional<User> findByUsername(String username);

    /**
     * Check if a username already exists.
     * Used while creating new users (clerks/managers).
     */
    boolean existsByUsername(String username);
}
