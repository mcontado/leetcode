package easy;

public class NumberComplement {
	public static int findComplement(int num)  {
//		int i = 0;
//		int j = 0;
//		
//		while (i < num) {
//			i += Math.pow(2, j);
//			j++;
//		}
//		
//		return i - num;
		
		return ~num & (Integer.highestOneBit(num) - 1);
	}
}
