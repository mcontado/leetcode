package easy;

import java.util.ArrayList;
import java.util.List;

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
