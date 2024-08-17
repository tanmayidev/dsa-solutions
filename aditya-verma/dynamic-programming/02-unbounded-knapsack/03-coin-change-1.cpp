// Question Link: https://www.geeksforgeeks.org/problems/coin-change2448/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution {
  public:
    long long int count(int coins[], int N, int sum) {
        vector<vector<long long int>> dp(N+1, vector<long long int>(sum+1));
        
        for(int n=0; n < N+1; n++) {
            for(int s=0; s < sum+1; s++) {
                if(s == 0) {
                    dp[n][s] = 1;
                } else if (n == 0) {
                    dp[n][s] = 0;
                }
            }
        }
        
        for(int n=1; n < N+1; n++) {
            for(int s=1; s < sum+1; s++) {
                if(coins[n-1] <= s) {
                    dp[n][s] = (dp[n][s - coins[n-1]] + dp[n-1][s]);
                }
                else {
                    dp[n][s] = dp[n-1][s];
                }
            }
        }
        
        return dp[N][sum];
    }
};