class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Create DP table
        // dp[i][j] = max dot product using elements from nums1[0..i] and nums2[0..j]
        int[][] dp = new int[m][n];
        
        // Base case: First cell - only one choice
        dp[0][0] = nums1[0] * nums2[0];
        
        // Fill first row: nums1[0] can pair with any element in nums2
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(
                dp[0][j - 1],           // Skip nums2[j], keep previous best
                nums1[0] * nums2[j]     // Use nums1[0] with nums2[j]
            );
        }
        
        // Fill first column: nums2[0] can pair with any element in nums1
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(
                dp[i - 1][0],           // Skip nums1[i], keep previous best
                nums1[i] * nums2[0]     // Use nums1[i] with nums2[0]
            );
        }
        
        // Fill the rest of the table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int currentProduct = nums1[i] * nums2[j];
                
                dp[i][j] = Math.max(
                    Math.max(
                        currentProduct,                      // Option 1: Start fresh
                        dp[i - 1][j - 1] + currentProduct   // Option 2: Add to previous
                    ),
                    Math.max(
                        dp[i - 1][j],                        // Option 3: Skip nums1[i]
                        dp[i][j - 1]                         // Option 4: Skip nums2[j]
                    )
                );
            }
        }
        
        // Bottom-right cell contains the answer
        return dp[m - 1][n - 1];
    }
}
