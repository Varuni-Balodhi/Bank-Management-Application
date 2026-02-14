package com.ymsli.bank.exception;

/**
 * Thrown when a user attempts an action
 * they are not authorized to perform
 * from a business perspective.
 *
 * Example:
 *  - Clerk trying to approve a withdrawal
 *  - Clerk trying to create an account
 */
public class UnauthorizedActionException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4388723108988031689L;

	public UnauthorizedActionException(String message) {
        super(message);
    }

    public UnauthorizedActionException(String message, Throwable cause) {
        super(message, cause);
    }
}
