package easy;

import java.util.Arrays;

public class PancakeSort {
	
	/**
	 * flips the array starting at the first element to the kth.
	 * @param arr the array to be flipped
	 * @param k the first kth element to flip
	 * ex: arr = [5 7 4 1 9], k = 4 (flip the first 4 elements)
	 * output:   [1 4 7 5 9] 
	 */
	public static void flip(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k == 1) {
			return;
		}
		
		//loop through the array 
		for (int i=0; i<k; i++) {
			int temp = arr[i];
			arr[i] = arr[k-1];
			arr[k-1] = temp;
			k--;
		}
	}
	
	/**
	 * Sorts the array by using only the flip method.
	 * @param arr the array to be sorted
	 * @return the sorted array
	 */
	public static int[] pancakeSort(int[] arr) {
		for (int i=arr.length-1; i>=0; i--) {
			int maxElemIdx = i;
			for (int j=i; j>=0; j--) {
				if (arr[j] > arr[maxElemIdx]) {
					maxElemIdx = j;
				}
			}
			flip(arr, maxElemIdx + 1);
			flip(arr, i + 1);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {5,7,4,8,1};
	
		pancakeSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
