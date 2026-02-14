package com.ymsli.bank.transaction;

import com.ymsli.bank.account.Account;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Many transactions belong to one account.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type; // DEPOSIT / WITHDRAWAL

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status; // COMPLETED / PENDING_APPROVAL / REJECTED

    /**
     * Clerk who initiated the transaction.
     */
    @Column(name = "performed_by", nullable = false, updatable = false)
    private Long performedBy;

    /**
     * Manager who approved/rejected (only for high-value withdrawals).
     */
    @Column(name = "approved_by")
    private Long approvedBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Required by JPA
    protected Transaction() {
    }

    public Transaction(Account account,
                       TransactionType type,
                       BigDecimal amount,
                       TransactionStatus status,
                       Long performedBy) {

        this.account = account;
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.performedBy = performedBy;
        this.createdAt = LocalDateTime.now();
    }

    /* ---------- Controlled state changes ---------- */

    public void markApproved(Long managerId) {
        this.status = TransactionStatus.COMPLETED;
        this.approvedBy = managerId;
    }

    public void markRejected(Long managerId) {
        this.status = TransactionStatus.REJECTED;
        this.approvedBy = managerId;
    }

    /* ---------- Getters only (immutability) ---------- */

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public Long getPerformedBy() {
        return performedBy;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
