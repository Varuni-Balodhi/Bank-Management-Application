package com.ymsli.bank.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    /**
     * Fetch all transactions with pagination (audit).
     */
    Page<Transaction> findAll(Pageable pageable);

    /**
     * Fetch transactions for a specific account
     * using business identifier.
     */
    Page<Transaction> findByAccount_AccountNumber(
            String accountNumber,
            Pageable pageable
    );

    /**
     * Fetch all transactions with a given status.
     * Used for pending approvals.
     */
    List<Transaction> findByStatus(TransactionStatus status);
}
