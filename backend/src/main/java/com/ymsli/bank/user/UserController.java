package com.ymsli.bank.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ymsli.bank.user.dto.CreateUserRequest;
import com.ymsli.bank.user.dto.UpdateUserRequest;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    // =====================================================
    // GET ALL USERS (Manager only)
    // =====================================================
    @GetMapping
    @PreAuthorize("hasRole('MANAGER')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // =====================================================
    // GET USER BY ID
    // =====================================================
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + id)
                );
    }

    // =====================================================
    // CREATE USER
    // =====================================================
    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public User createUser(@Valid @RequestBody CreateUserRequest request) {

        if (request.getRole() == Role.MANAGER) {
            return userService.createManager(
                    request.getUsername(),
                    request.getPassword()
            );
        }

        return userService.createClerk(
                request.getUsername(),
                request.getPassword()
        );
    }

    // =====================================================
    // UPDATE USER ROLE (Manager only)
    // =====================================================
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public User updateUserRole(@PathVariable Long id,
                               @RequestBody UpdateUserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + id)
                );

        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    // =====================================================
    // DELETE USER
    // =====================================================
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public String deleteUser(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found: " + id)
                );

        userRepository.delete(user);

        return "User deleted successfully";
    }
}
