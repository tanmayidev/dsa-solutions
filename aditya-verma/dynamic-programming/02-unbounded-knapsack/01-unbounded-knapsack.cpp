// Question Link : https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution{
public:
    int knapSack(int N, int W, int val[], int wt[])
    {
        // duplicate items allowed, so included items can be included again
        
        vector<vector<int>> dp(N+1, vector<int>(W+1));
        // N = len of array
        // W = capacity of knapsack
        
        // base conditions
        for(int n=0; n < N+1; n++) {
            for(int w=0; w < W+1; w++) {
                if(w == 0 || n == 0) {
                    dp[n][w] = 0;
                }
            }
        }
        
        // critical condition
        for(int n=1; n < N+1; n++) {
            for(int w=1; w < W+1; w++) {
                if(wt[n-1] <= w) {
                    dp[n][w] = max((val[n-1] + dp[n][w - wt[n-1]]), dp[n-1][w]);
                }
                else {
                    dp[n][w] = dp[n-1][w];
                }
            }
        }
        
        return dp[N][W];
    }
};