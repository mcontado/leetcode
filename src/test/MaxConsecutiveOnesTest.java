package test;

import static org.junit.Assert.*;

import org.junit.Test;

import easy.MaxConsecutiveOnes;

public class MaxConsecutiveOnesTest {

	@Test
	public void test() {
		int[] arr = {1,1,0,1,1,1};
		int expectedResult = 3;
		
		int actualResult = MaxConsecutiveOnes.findMaxConsecutiveOnes(arr);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test2() {
		int[] arr = {1,0,1,1,0,1};
		int expectedResult = 2;
		
		int actualResult = MaxConsecutiveOnes.findMaxConsecutiveOnes(arr);
		
		assertEquals(expectedResult, actualResult);
	}

}
