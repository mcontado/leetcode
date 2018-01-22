package easy;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 
 Example 1:
 Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 Output: True
	Explanation:
	1234
	5123
	9512

 In the above grid, the diagonals 
 are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and 
 in each diagonal all elements are the same, so the answer is True.
 
 Example 2:
 Input: matrix = [[1,2],[2,2]]
 Output: False
 Explanation:
 The diagonal "[1, 2]" has different elements.
 
 */
public class ToeplitzMatrix {

	public static void main(String[] args) {
		 int mat[][] = { 
				 { 6, 7, 8, 9 },
                 { 4, 6, 7, 8 },
                 { 1, 4, 6, 7 },
                 { 0, 1, 4, 6 },
                 { 2, 0, 1, 4 }
               };

		 if (isToeplitzMatrix(mat))
		     System.out.println("Matrix is a Toeplitz ");
		 else
		     System.out.println("Matrix is not a Toeplitz ");

	}
	
	 public static boolean isToeplitzMatrix(int[][] matrix) {
		 // do for each element in the first row
		 for (int i=0; i<matrix[0].length; i++) {
			 if (!checkDiagonal(matrix, 0, i)) {
				 return false;
			 }
				 
		 }
		 
		 // do for each element in the first column
		 for (int i=1; i<matrix.length; i++) {
			 // check descending diagonal starting from
	         // position (i, 0) in the matrix
			 if (!checkDiagonal(matrix, i, 0)) {
				 return false;
			 }		 
		 }
		 
	     return true;
	 }

	private static boolean checkDiagonal(int[][] matrix, int i, int j) {
		int result = matrix[i][j];
		
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		
		while (++i < rowLength && ++j < colLength) {
			if (matrix[i][j] != result) {
				return false;
			}
		}
		
		// we only reach here when all elements
        // in given diagonal are same
        return true;
	}

}
