package com.ymsli.bank.transaction;

/**
 * Represents the lifecycle state of a transaction.
 */
public enum TransactionStatus {

    /**
     * Transaction is fully processed.
     * - Deposits
     * - Withdrawals within approval limit
     * - Approved high-value withdrawals
     */
    COMPLETED,

    /**
     * High-value withdrawal initiated by clerk
     * and waiting for manager approval.
     */
    PENDING_APPROVAL,

    /**
     * High-value withdrawal rejected by manager.
     * Balance remains unchanged.
     */
    REJECTED
}
