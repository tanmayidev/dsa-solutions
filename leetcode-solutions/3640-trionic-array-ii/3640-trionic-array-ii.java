```java
class Solution {

    /**
     * Finds the maximum sum of a "trionic" subsequence in the array.
     * A trionic pattern consists of three segments: increasing → decreasing → increasing
     * 
     * @param nums the input array
     * @return maximum sum of a valid trionic subsequence, or Long.MIN_VALUE if none exists
     */
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long maxAnswer = Long.MIN_VALUE;

        int i = 0;
        while (i < n) {
            int current = i + 1;

            // === SEGMENT 1: Find increasing segment ===
            int peakIndex = findIncreasingEnd(nums, i);
            
            if (peakIndex == i) {
                i++;
                continue;
            }

            // === SEGMENT 2: Find decreasing segment ===
            int valleyIndex = findDecreasingEnd(nums, peakIndex);

            if (!isValidValley(nums, peakIndex, valleyIndex, n)) {
                i = valleyIndex + 1;
                continue;
            }

            // === Calculate sum of the three segments ===
            long totalSum = calculateTrionicSum(nums, i, peakIndex, valleyIndex);

            maxAnswer = Math.max(maxAnswer, totalSum);
            i = valleyIndex;
        }

        return maxAnswer;
    }

    /**
     * Finds the end index of an increasing segment starting at startIndex.
     */
    private int findIncreasingEnd(int[] nums, int startIndex) {
        int j = startIndex + 1;
        while (j < nums.length && nums[j - 1] < nums[j]) {
            j++;
        }
        return j - 1;
    }

    /**
     * Finds the end index of a decreasing segment starting at peakIndex.
     */
    private int findDecreasingEnd(int[] nums, int peakIndex) {
        int j = peakIndex + 1;
        while (j < nums.length && nums[j - 1] > nums[j]) {
            j++;
        }
        return j - 1;
    }

    /**
     * Checks if the valley position forms a valid trionic pattern.
     */
    private boolean isValidValley(int[] nums, int peakIndex, int valleyIndex, int n) {
        // Valley must be different from peak
        if (valleyIndex == peakIndex) return false;
        
        // Must have room for third segment
        if (valleyIndex >= n - 1) return false;
        
        // Third segment must start increasing
        if (nums[valleyIndex + 1] <= nums[valleyIndex]) return false;
        
        return true;
    }

    /**
     * Calculates the maximum sum of a trionic subsequence given the key indices.
     */
    private long calculateTrionicSum(int[] nums, int start, int peakIndex, int valleyIndex) {
        long sum = 0;

        // Core elements: peak and its neighbors
        sum += nums[peakIndex] + nums[peakIndex - 1];

        // Add decreasing segment (valley side)
        for (int k = peakIndex + 1; k <= valleyIndex; k++) {
            sum += nums[k];
        }

        // Add first element of third segment (required)
        sum += nums[valleyIndex + 1];

        // Add best optional suffix from third increasing segment
        sum += findMaxPrefixSum(nums, valleyIndex + 2, true);

        // Add best optional prefix from first increasing segment
        sum += findMaxSuffixSum(nums, start, peakIndex - 2);

        return sum;
    }

    /**
     * Finds the maximum prefix sum while the segment is increasing.
     */
    private long findMaxPrefixSum(int[] nums, int startIndex, boolean checkIncreasing) {
        long maxSum = 0;
        long currentSum = 0;
        
        for (int k = startIndex; k < nums.length; k++) {
            if (checkIncreasing && nums[k] <= nums[k - 1]) break;
            
            currentSum += nums[k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    /**
     * Finds the maximum suffix sum from endIndex down to startIndex.
     */
    private long findMaxSuffixSum(int[] nums, int startIndex, int endIndex) {
        long maxSum = 0;
        long currentSum = 0;
        
        for (int k = endIndex; k >= startIndex; k--) {
            currentSum += nums[k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
```
