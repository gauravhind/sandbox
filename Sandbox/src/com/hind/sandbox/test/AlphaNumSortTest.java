package com.hind.sandbox.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hind.sandbox.AlphaNumSort;

public class AlphaNumSortTest {

	@Test
	public void testSingleNumeric(){
		String test = "7";
		String sortedValue = "[7]";
		AlphaNumSort alpha = new AlphaNumSort(test);
		assertEquals(sortedValue,alpha.doAlphaNumSort());
	}
	
	@Test
	public void testSingleString(){
		String test = "NewYork";
		String sortedValue = "[NewYork]";
		AlphaNumSort alpha = new AlphaNumSort(test);
		assertEquals(sortedValue,alpha.doAlphaNumSort());
	}
	
	@Test
	public void testStringOnly() {
		String test = "NewYork Atlanta Texas Delhi Mumbai London Frankfurt";
		String sortedValue = "[Atlanta, Delhi, Frankfurt, London, Mumbai, NewYork, Texas]";
		AlphaNumSort alpha = new AlphaNumSort(test);
		assertEquals(sortedValue,alpha.doAlphaNumSort());
		
	}
	
	@Test
	public void testNumericOnly(){
		String test = "9 6 8 7 4 2 4 1";
		String sortedValue = "[1, 2, 4, 4, 6, 7, 8, 9]";
		AlphaNumSort alpha = new AlphaNumSort(test);
		assertEquals(sortedValue,alpha.doAlphaNumSort());
	}

	@Test
	public void testAlphaAndNumeric(){
		//String test = "NewYork 5 Atlanta Texas 2 Delhi Mumbai London 4 Frankfurt";
		String test = "car truck 8 4 bus 6 1";
		String sortedValue = "[bus, car, 1, 4, truck, 6, 8]";
		//"[Atlanta, 2, Delhi, Frankfurt, 4, London, Mumbai, NewYork, 5, Texas]";
		AlphaNumSort alpha = new AlphaNumSort(test);
		assertEquals(sortedValue,alpha.doAlphaNumSort());
	}
	
}
