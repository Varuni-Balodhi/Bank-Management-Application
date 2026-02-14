package com.ymsli.bank.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateAccountRequest {

    private final String accountNumber;
    private final String holderName;
    private final BigDecimal balance;
    private final LocalDateTime createdAt;
    private final String message;

    public CreateAccountRequest(String accountNumber,
                                 String holderName,
                                 BigDecimal balance,
                                 LocalDateTime createdAt,
                                 String message) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.createdAt = createdAt;
        this.message = message;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getMessage() {
        return message;
    }
}
