package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made 
 * by randomizing the order of the elements in A.
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means 
 * the ith element in A appears in B at index j.
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
 * For example, given
 * 
 * A = [12, 28, 46, 32, 50]
 * B = [50, 12, 32, 46, 28]
 * 
 * We should return 
 * [1, 4, 3, 2, 0] as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 
 * because the 1st element of A appears at B[4], and so on.
 * 
 * Note:
A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
 * @author tet
 *
 */
public class AnagramMappings {

	public static void main(String[] args) {
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		System.out.println(Arrays.toString(anagramMappingUsingMap(A, B)));

	}
	
	/**
	 * Using 2 for loops 
	 * @param A first array
	 * @param B second array
	 * @return the result
	 */
    public static int[] anagramMappings(int[] A, int[] B) {
       int[] result = new int[A.length];
       
       // loop over the array list of A
       for (int i=0; i<A.length; i++) {
    	   int current = A[i];
    	   
    	   for (int j=0; j<B.length; j++) {
    		   if (current == B[j]) {
    			   result[i] = j;
    			   break;
    		   }
    	   }
    	   
       }
       
       return result;
    }
    
    /**
     * Using HashMap for more efficiency
     * @param A
     * @param B
     * @return
     */
    public static int[] anagramMappingUsingMap(int[] A, int[] B) {
    	int[] result = new int[A.length];
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	for (int i=0; i<A.length; i++) {
    		map.put(B[i], i);
    	}
    	
    	for (int i=0; i<A.length; i++) {
    		result[i] = map.get(A[i]);
    	}
    	
    	return result;
    }
	
	

}
