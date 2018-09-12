package com.zenvia;

public class Withdraw {

	/**
	 * Withdraw value as entered by the user.
	 */
	int value;
	
	/**
	 * Gets the value of the withdraw
	 * @return
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Creates an withdraw.
	 * @param value Value to compute the number of bills.
	 */
	public Withdraw(int value) {
		this.value = value;
	}
	
	/**
	 * Computes the necessary bills to complete the withdraw.
	 */
	public WithdrawResult compute() {
		
		if (value < 0)
			return new WithdrawResult(WithdrawState.Error);
		
		int remainder = value;
		
		int hundreds = 0;
		int fifties = 0;
		int twenties = 0;
		int tens = 0;
		
		// computes the number of hundreds
		if (remainder / 100 > 0) {
			hundreds = remainder / 100;
			remainder -= hundreds * 100;
		}
		
		// computes the number of fifties
		if (remainder / 50 > 0) {
			fifties = remainder / 50;
			remainder -= fifties * 50;
		}
		
		// computes the number of twenties
		if (remainder / 20 > 0) {
			twenties = remainder / 20;
			remainder -= twenties * 20;
		}
		
		// computes the number of tens
		if (remainder / 10 > 0) {
			tens = remainder / 10;
			remainder -= tens * 10;
		}
		
		// returns the computed withdraw
		return remainder == 0 ? new WithdrawResult(hundreds, fifties, twenties, tens) : // successful withdraw
			                    new WithdrawResult(WithdrawState.Error); // withdraw did not complete entirely
	}
}
