package easy;

import java.util.HashSet;
import java.util.Set;

public class FindAllPairsInArrayofIntegers {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		int sum = 5;
		printPairsUsingSet(array, sum);
	}

	/**
	 * * Prints all pair of integer values from given array whose sum is is
	 * equal to given number. * complexity of this solution is O(n^2)
	 */
	public static void printPairs(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			int first = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int second = array[j];
				if ((first + second) == sum) {
					System.out.printf("(%d, %d) %n", first, second);
				}
			}
		}
	}

	/** * Given an array of integers finds two elements in the array whose sum is equal to n. * @param numbers * @param n */ 
	public static void printPairsUsingSet(int[] numbers, int n) { 
		if(numbers.length < 2) { 
			return; 
		} 
		
		HashSet<Integer> set = new HashSet<Integer>(numbers.length); 
		for(int value : numbers){
			int target = n - value; 
			// if target number is not in set then add 
			if(!set.contains(target)) { 
				set.add(value); 
			} else { 
				System.out.printf("(%d, %d) %n", value, target); 
			} 
		} 
	
	}
	
}


