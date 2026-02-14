package com.ymsli.bank.transaction;

/**
 * Represents the type of financial transaction.
 */
public enum TransactionType {

    /**
     * Money added to an account.
     * - Always processed immediately
     * - Does NOT require approval
     */
    DEPOSIT,

    /**
     * Money removed from an account.
     * - May require manager approval based on amount
     */
    WITHDRAWAL
}
