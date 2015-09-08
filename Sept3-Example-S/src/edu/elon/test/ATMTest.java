package edu.elon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {
	private ATM myATM;
	
	@Before
	public void setUp() throws Exception {
		myATM = new ATM(30);
	}

	@After
	public void tearDown() throws Exception {
		myATM = null;
	}
	
	@Test
	public void testGetBalance(){
		double expected = 30;
		double actual = myATM.getBalance();
		assertEquals(expected,actual,0);
	}
	
	@Test
	public void testDeposit() {
		myATM.deposit(20);
		double test = myATM.getBalance();
		double expected = 50;
		assertEquals(expected, test,0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentException(){
		myATM.deposit(-15);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalArgumentExceptionWithdraw(){
		myATM.withdraw(400);
	}
	
	@Test
	public void testWithdraw() {
		double actual = myATM.withdraw(10);
		double expected = 10;
		assertEquals(expected, actual, 0);
	}

}
