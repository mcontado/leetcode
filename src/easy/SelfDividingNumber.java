package easy;

import java.util.ArrayList;
import java.util.List;
/**
 * A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * 
 * Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]


 * @author tet
 *
 */
public class SelfDividingNumber {

	public static void main(String[] args) {
		int left = 1;
		int right = 22;
		System.out.println(selfDividingNumbers(left, right));

	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i=left; i<=right; i++) {
			if (isSelfDividingNumber(i)) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	public static boolean isSelfDividingNumber(int n) {
		int original = n;
		while (n > 0) {
			int remainder = n % 10;
			if (remainder == 0) {
				return false;
			}
			if (original % remainder != 0) {
				return false;
			}
			n /= 10;
		}
		return true;
	}
}
