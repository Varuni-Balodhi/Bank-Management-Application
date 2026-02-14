package com.ymsli.bank.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Find account by business identifier (account number).
     */
    Optional<Account> findByAccountNumber(String accountNumber);

    /**
     * Check if an account number already exists.
     */
    boolean existsByAccountNumber(String accountNumber);
}
