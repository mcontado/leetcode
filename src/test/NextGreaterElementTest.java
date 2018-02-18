package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import easy.NextGreaterElement;

public class NextGreaterElementTest {

	@Test
	public void testNextGreaterElement() {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		int[] expectedResult = {-1,3,-1};
		
		int[] actualResult = NextGreaterElement.nextGreaterElement(nums1, nums2);
		
		assertTrue(Arrays.equals(expectedResult, actualResult));
	}

	@Test
	public void testNextGreaterElement2() {
		int[] nums1 = {2,4};
		int[] nums2 = {1,2,3,4};
		int[] expectedResult = {3,-1};
		
		int[] actualResult = NextGreaterElement.nextGreaterElement(nums1, nums2);
		
		assertTrue(Arrays.equals(expectedResult, actualResult));
	}
}
