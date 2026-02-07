package com.ymsli.bank.user;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean active = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Required by JPA
    protected User() {
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password; // already encoded
        this.role = role;
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    /* ---------- Getters only (controlled updates) ---------- */

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /* ---------- Domain-safe methods ---------- */

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

	public void setUsername(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword1(String encode) {
		// TODO Auto-generated method stub
		
	}

}
