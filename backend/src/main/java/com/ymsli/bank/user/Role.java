package com.ymsli.bank.user;

/**
 * Represents system roles for bank employees.
 */
public enum Role {

    /**
     * System administrator and final authority.
     * - Creates accounts
     * - Manages clerks
     * - Approves high-value withdrawals
     * - Views full audit history
     */
    MANAGER,

    /**
     * Performs daily banking operations.
     * - Deposits
     * - Withdrawals
     * - Initiates high-value withdrawal requests
     */
    CLERK
}
