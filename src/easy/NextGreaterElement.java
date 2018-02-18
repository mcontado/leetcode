package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements
  are subset of nums2. Find all the next greater numbers for nums1's elements in the
  corresponding places of nums2.

 The Next Greater Number of a number x in nums1 is the first greater number to its right 
 in nums2. If it does not exist, output -1 for this number.

Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.


 */
public class NextGreaterElement {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
