package easy;

public class MaxConsecutiveOnes {
	
	public static int findMaxConsecutiveOnes(int[] nums) {
        int maxNumConsecutive = 0;
        int currentMax = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                maxNumConsecutive++;
                if (maxNumConsecutive > currentMax) {
                	currentMax = maxNumConsecutive;
                }
            } else {
                maxNumConsecutive = 0;
            }
        }
        
        return currentMax;
        
        /*
        leet code 4 lines of code solution:
         
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max; 
        
         */
    }
}
