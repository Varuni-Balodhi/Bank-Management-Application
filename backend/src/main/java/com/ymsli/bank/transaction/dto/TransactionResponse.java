package com.ymsli.bank.transaction.dto;

import com.ymsli.bank.transaction.TransactionStatus;
import com.ymsli.bank.transaction.TransactionType;
import com.ymsli.bank.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {

    private final Long transactionId;
    private final String accountNumber;
    private final TransactionType transactionType;
    private final BigDecimal amount;
    private final TransactionStatus status;
    private final Long performedBy;
    private final User approvedBy;
    private final LocalDateTime createdAt;

    public TransactionResponse(Long transactionId,
                               String accountNumber,
                               TransactionType transactionType,
                               BigDecimal amount,
                               TransactionStatus status,
                               Long performedBy,
                               User approvedBy,
                               LocalDateTime createdAt) {

        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.status = status;
        this.performedBy = performedBy;
        this.approvedBy = approvedBy;
        this.createdAt = createdAt;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public TransactionType getTransactionType() {
        return transactionType;
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

    public User getApprovedBy() {
        return approvedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
