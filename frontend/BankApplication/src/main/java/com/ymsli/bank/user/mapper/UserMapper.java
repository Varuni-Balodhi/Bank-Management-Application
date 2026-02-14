package com.ymsli.bank.user.mapper;

import com.ymsli.bank.user.User;
import com.ymsli.bank.user.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                user.isActive()
        );
    }
}
