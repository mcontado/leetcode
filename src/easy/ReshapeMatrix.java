package easy;

import java.util.Arrays;

public class ReshapeMatrix {

	public static void main(String[] args) {
		int[][] nums = { { 1, 2 }, { 3, 4 } };
		System.out.println("Original String: " + Arrays.deepToString(nums));
		System.out.println("Output: " + Arrays.deepToString(reshapeMatrix(nums, 1, 4)));
	}

	public static int[][] reshapeMatrix(int[][] nums, int r, int c) {
		int m = nums.length; // row length
		int n = nums[0].length; // column length

		// edge case: check if the matrix can reshape by checking the row * col
		// is equals to the matrix row * col
		if (r * c != n * m) {
			return nums;
		}

		// create int array of results with row and column length as r and c
		// respectively
		int[][] result = new int[r][c];

		// set the starting row and col as 0 for the new matrix
		int row = 0, col = 0;

		// traverse through the orignal matrix
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// save the data into the new results matrix;
				result[row][col] = nums[i][j];
				// increment the column
				col++;

				// check if the column is equal to the c, (requested column
				// count)
				if (col == c) {
					// set back the col to 0
					col = 0;
					// increment the row;
					row++;
				}
			}
		}

		return result;
	}

}
