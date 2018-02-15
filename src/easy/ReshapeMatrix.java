package easy;

import java.util.Arrays;

public class ReshapeMatrix {
	
	public static void main(String[] args) {
		int[][] nums = {{1,2}, {3,4}};
		System.out.println("Original String: " + Arrays.deepToString(nums));
		System.out.println("Output: " + Arrays.deepToString(reshapeMatrix(nums, 1, 4)));
	}
	
	public static int[][] reshapeMatrix(int[][] nums, int r, int c) {
		int m = nums.length;
		int n = nums[0].length;
		
		if (m * n != r * c) {
			return nums;
		}
		
		int[][] result = new int[r][c];
		
		int row = 0, col = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[row][col] = nums[i][j];
				col++;
				
				if (col == c) {
					col = 0;
					row++;
				}
			}
		}
		
		return result;
	}

}
