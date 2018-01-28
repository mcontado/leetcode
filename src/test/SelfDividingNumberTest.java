package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import easy.SelfDividingNumber;

public class SelfDividingNumberTest {

	@Test
	public void testSelfDividingNumbers() {
		// Arrange
		int left = 1;
		int right = 22;
		
		final List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
		
		// Act
		final List<Integer> actualResult = SelfDividingNumber.selfDividingNumbers(left, right);
		
		// Assert
		assertNotNull(actualResult);
		assertEquals(Arrays.asList(expectedList), Arrays.asList(actualResult));
	}

}
