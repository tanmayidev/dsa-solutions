class Solution {
    public int countPartitions(int[] arr, int diff) {

        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // Invalid case
        if ((totalSum + diff) % 2 != 0) return 0;

        int target = (totalSum + diff) / 2;

        return countSubsets(arr, target);
    }

    private int countSubsets(int[] arr, int target) {

        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        // Base case
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= target; sum++) {

                // Not take
                dp[i][sum] = dp[i - 1][sum];

                // Take
                if (arr[i - 1] <= sum) {
                    dp[i][sum] += dp[i - 1][sum - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}