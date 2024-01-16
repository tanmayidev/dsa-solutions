// Question Link : https://practice.geeksforgeeks.org/problems/partitions-with-given-difference/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution {
  public:
    int countPartitions(int N, int D, vector<int>& arr) {
        // S1 - S2 = D
        // Sum = sum of elements of array
        // S1 + S2 = Sum
        // S1 = Sum - S2
        // Sum - S2 - S2 = D
        // Sum - 2*S2 = D
        // S2 = ( Sum - D ) / 2
        
        // 2*S1 = D + Sum
        // S1 = (D + Sum ) / 2
        // The number of subsets that can create S2 will be same as number of subsets that can create S1
        // So the count of subsets of S2 is the solution
        
        int mod = 1000000007;
        
        int arrSum = 0;
        for(int s = 0; s < N; s++ ) {
            arrSum = (arrSum + arr[s]);
        }
        
        // very imp condition
        if((arrSum+D)%2 != 0) {
            return 0;
        }
        
        int targetSum = (arrSum + D)/ 2;
        
        vector<vector<int>> dp(N+1, vector<int>(targetSum+1, 0));
        
        // base conditions
        for(int s=0; s < targetSum+1; s++ ) {
            dp[0][s] = 0; // n == 0 and s == any value
        }
        
        dp[0][0] = 1; // s == 0 and n == 0
        
        // main condition
        
        for(int n=1; n < N+1; n++) {
            for(int s =0; s < targetSum+1; s++) {
                if(arr[n-1] <= s) {
                    dp[n][s] = (dp[n-1][s - arr[n-1]] + dp[n-1][s])%mod;
                }
                else {
                    dp[n][s] = dp[n-1][s];
                }
            }
        }
        
        return dp[N][targetSum];
        
    }
};