package com.ymsli.bank.user;

import com.ymsli.bank.exception.BusinessException;
import com.ymsli.bank.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Create a new clerk user.
     * Only MANAGER should be allowed to call this.
     */
    public User createClerk(String username, String rawPassword) {

        if (userRepository.existsByUsername(username)) {
            throw new BusinessException(
                    "Username already exists: " + username
            );
        }

        String encodedPassword =
                passwordEncoder.encode(rawPassword);

        User user = new User(
                username,
                encodedPassword,
                Role.CLERK
        );

        return userRepository.save(user);
    }

    /**
     * Create a new manager user (optional / admin use).
     */
    public User createManager(String username, String rawPassword) {

        if (userRepository.existsByUsername(username)) {
            throw new BusinessException(
                    "Username already exists: " + username
            );
        }

        String encodedPassword =
                passwordEncoder.encode(rawPassword);

        User user = new User(
                username,
                encodedPassword,
                Role.MANAGER
        );

        return userRepository.save(user);
    }

    /**
     * Deactivate a user (soft disable).
     */
    public void deactivateUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found: " + userId
                        )
                );

        user.deactivate();
        userRepository.save(user);
    }

    /**
     * Reactivate a user.
     */
    public void activateUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found: " + userId
                        )
                );

        user.activate();
        userRepository.save(user);
    }

    /**
     * Fetch user by username (internal use).
     */
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found: " + username
                        )
                );
    }
}
