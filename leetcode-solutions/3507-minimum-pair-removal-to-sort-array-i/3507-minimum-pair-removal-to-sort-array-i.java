class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;
        
        // Keep performing operations until array is non-decreasing
        while (!isNonDecreasing(nums)) {
            // Find the leftmost pair with minimum sum
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;
            
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = i;
                }
            }
            
            // Replace the pair with their sum
            nums = mergePair(nums, minIndex);
            operations++;
        }
        
        return operations;
    }
    
    private boolean isNonDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    // Merge pair at index i with i+1 and return new array
    private int[] mergePair(int[] nums, int index) {
        int[] result = new int[nums.length - 1];
        int j = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                // Merge this element with the next one
                result[j++] = nums[i] + nums[i + 1];
                i++; // Skip the next element
            } else {
                result[j++] = nums[i];
            }
        }
        
        return result;
    }
}
