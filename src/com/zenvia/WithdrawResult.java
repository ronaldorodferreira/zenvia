package com.zenvia;

public class WithdrawResult {

	/**
	 * Number of one hundred bills needed in the withdraw.
	 */
	int hundreds = 0;
	
	/**
	 * Number of fifties bills needed in the withdraw.
	 */
	int fifties = 0;
	
	/**
	 * Number of twenties bills needed in the withdraw.
	 */
	int twenties = 0;
	
	/**
	 * Number of tens bills needed in the withdraw.
	 */
	int tens = 0;
	
	/**
	 * State of the withdraw request.
	 */
	WithdrawState state;
	
	
	public WithdrawResult (int hundreds, int fifties, int twenties, int tens) {
		this.hundreds = hundreds;
		this.fifties = fifties;
		this.twenties = twenties;
		this.tens = tens;
		this.state = WithdrawState.Success;
	}
	
	public WithdrawResult (WithdrawState state) {
		this.state = state;
	}
	
	/**
	 * Number of one hundred bills needed in the withdraw.
	 * @return 0 if withdraw was not successful.
	 */
	public int getHundreds() {
		return state == WithdrawState.Success ? hundreds : 0;
	}
	
	/**
	 * Number of fifties bills needed in the withdraw.
	 * @return 0 if withdraw was not successful.
	 */
	public int getFifties() {
		return state == WithdrawState.Success ? fifties : 0;
	}
	
	/**
	 * Number of twenties bills needed in the withdraw.
	 * @return 0 if withdraw was not successful.
	 */
	public int getTwenties() {
		return state == WithdrawState.Success ? twenties : 0;
	}
	
	/**
	 * Number of tens bills needed in the withdraw.
	 * @return 0 if withdraw was not successful.
	 */
	public int getTens() {
		return state == WithdrawState.Success ? tens : 0;
	}
	
	public WithdrawState getWithdrawState() {
		return state;
	}
	
	@Override
	public String toString() {
		return String.format("[%d,%d,%d,%d,%s]", hundreds, fifties, twenties, tens, state.toString());
	}
}
