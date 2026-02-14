package com.ymsli.bank.exception;

/**
 * Thrown when a business rule is violated.
 * Example:
 *  - Insufficient balance
 *  - Withdrawal without approval
 *  - Invalid transaction state
 */
public class BusinessException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5695914552174402653L;

	public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
