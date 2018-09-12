package com.zenvia.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zenvia.Withdraw;
import com.zenvia.WithdrawResult;
import com.zenvia.WithdrawState;

public class WithdrawTest {

	@Test
	public void testGetValue() {
		Withdraw w = new Withdraw(100);
		assertEquals(w.getValue(), 100);
	}

	@Test
	public void testCompute_NegativeValue() {
		WithdrawResult r = new Withdraw(-10).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Error);
		assertEquals(r.getHundreds(), 0);
		assertEquals(r.getFifties(), 0);
		assertEquals(r.getTwenties(), 0);
		assertEquals(r.getTens(), 0);
	}

	@Test
	public void testCompute_IncorrectValue() {
		WithdrawResult r = new Withdraw(123).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Error);
		assertEquals(r.getHundreds(), 0);
		assertEquals(r.getFifties(), 0);
		assertEquals(r.getTwenties(), 0);
		assertEquals(r.getTens(), 0);
	}
	
	@Test
	public void testCompute_ValueZero() {
		WithdrawResult r = new Withdraw(0).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Success);
		assertEquals(r.getHundreds(), 0);
		assertEquals(r.getFifties(), 0);
		assertEquals(r.getTwenties(), 0);
		assertEquals(r.getTens(), 0);
	}
	
	@Test
	public void testCompute_Value1() {
		WithdrawResult r = new Withdraw(100).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Success);
		assertEquals(r.getHundreds(), 1);
		assertEquals(r.getFifties(), 0);
		assertEquals(r.getTwenties(), 0);
		assertEquals(r.getTens(), 0);
	}
	
	@Test
	public void testCompute_Value2() {
		WithdrawResult r = new Withdraw(150).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Success);
		assertEquals(r.getHundreds(), 1);
		assertEquals(r.getFifties(), 1);
		assertEquals(r.getTwenties(), 0);
		assertEquals(r.getTens(), 0);
	}
	
	@Test
	public void testCompute_Value3() {
		WithdrawResult r = new Withdraw(170).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Success);
		assertEquals(r.getHundreds(), 1);
		assertEquals(r.getFifties(), 1);
		assertEquals(r.getTwenties(), 1);
		assertEquals(r.getTens(), 0);
	}
	
	@Test
	public void testCompute_Value4() {
		WithdrawResult r = new Withdraw(180).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Success);
		assertEquals(r.getHundreds(), 1);
		assertEquals(r.getFifties(), 1);
		assertEquals(r.getTwenties(), 1);
		assertEquals(r.getTens(), 1);
	}
	
	@Test
	public void testCompute_Value5() {
		WithdrawResult r = new Withdraw(190).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Success);
		assertEquals(r.getHundreds(), 1);
		assertEquals(r.getFifties(), 1);
		assertEquals(r.getTwenties(), 2);
		assertEquals(r.getTens(), 0);
	}
	
	@Test
	public void testCompute_Value6() {
		WithdrawResult r = new Withdraw(30).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Success);
		assertEquals(r.getHundreds(), 0);
		assertEquals(r.getFifties(), 0);
		assertEquals(r.getTwenties(), 1);
		assertEquals(r.getTens(), 1);
	}
	
	@Test
	public void testCompute_Value7() {
		WithdrawResult r = new Withdraw(80).compute();		
		assertEquals(r.getWithdrawState(), WithdrawState.Success);
		assertEquals(r.getHundreds(), 0);
		assertEquals(r.getFifties(), 1);
		assertEquals(r.getTwenties(), 1);
		assertEquals(r.getTens(), 1);
	}
}
