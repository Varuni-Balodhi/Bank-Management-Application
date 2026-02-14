package com.ymsli.bank.transaction.dto;

import java.math.BigDecimal;

public class DepositRequest {

    private String accountNumber;
    private BigDecimal amount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
