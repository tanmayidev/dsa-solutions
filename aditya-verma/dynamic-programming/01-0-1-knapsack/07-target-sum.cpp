// Question Link : https://leetcode.com/problems/target-sum/

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        // S1 - S2 = target
        // S1 + S2 = arrSum
        // 2*S1 = target + arrSum
        // S1 = ( target + arrSum ) / 2
        // Count the number of subsets to get S1
        int arrSum = 0;
        int N = nums.size();
        for(int i=0; i<N; i++) {
            arrSum += nums[i];
        }

        int discriminant =  target + arrSum ;
        // very important condition
        if(discriminant%2 != 0 || discriminant < 0) {
            return 0;
        }

        int targetSum = discriminant / 2;
        
        vector<vector<int>> dp(N+1, vector<int>(targetSum+1));
        for(int s=0; s < targetSum+1; s++) {
            dp[0][s] = 0;
        }

        dp[0][0] = 1;  // n==0 and s==0 i.e., nullset is possible

        for(int n=1; n < N+1; n++) {
            for(int s=0; s < targetSum+1; s++) {
                if(nums[n-1] <= s) {
                    dp[n][s] = dp[n-1][s - nums[n-1]] + dp[n-1][s];
                }
                else {
                    dp[n][s] = dp[n-1][s];
                }
            }
        }

        return dp[N][targetSum];
    }
};