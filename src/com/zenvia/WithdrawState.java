package com.zenvia;

/**
 * State of the withdraw requested by the user.
 * @author ronaldo
 *
 */
public enum WithdrawState {

	/**
	 * Withdraw was successful.
	 */
	Success,
	/**
	 * An error occurred and the withdraw could not be processed.
	 */
	Error,
	/**
	 * Withdraw is pending to be processed.	
	 */
	Processing
}
