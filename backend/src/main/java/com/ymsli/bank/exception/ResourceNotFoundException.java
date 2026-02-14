package com.ymsli.bank.exception;

/**
 * Thrown when a requested resource does not exist.
 * Example:
 *  - Account not found
 *  - Transaction not found
 *  - User not found
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2861402536746365769L;

	public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
