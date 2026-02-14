package com.ymsli.bank.user.dto;

import com.ymsli.bank.user.Role;

public class UpdateUserRequest {

    private String password;
    private Boolean active;
    private Role role;

    // ===== GETTERS & SETTERS =====

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
