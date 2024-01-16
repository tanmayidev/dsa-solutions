// Question Link : https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution
{
    int memo[10001][10001];

    public:
    
    // memoized
    // Ensure that the calling function has memset the memo with -1 throughout
    int knapSackMemoized(int W, int wt[], int val[], int N) 
    {
        if (N == 0 || W == 0) {
            return 0;
        }

        if (memo[N][W] == -1) {
            return memo[N][W];
        }

        if (wt[N-1] <= W) {
            return memo[N][W] = Math.max(val[N-1] + knapSackMemoized(W - wt[N-1], wt, val, N-1), knapSackMemoized(W, wt, val, N-1));
        } else {
            return memo[N][W] = knapSackMemoized(W, wt, val, N-1);
        }
    }
    
    // recursive
    int knapSackRecursive(int W, int wt[], int val[], int N) 
    { 
       if (N == 0 || W == 0) {
        return 0;
       }

       if (wt[N-1] <= W) {
        return Math.max(val[N-1] + knapSackRecursive(W - wt[N-1], wt, val, N-1), knapSackRecursive(W, wt, val, N-1))
       } else {
        return knapSackRecursive(W, wt, val, N-1);
       }
    }

    // iterative
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int N) 
    { 
       int dp[N+1][W+1];
       
       // initial condition
       for(int n = 0; i < N+1; i++) {
           for(int w = 0; w < W+1; w++) {
               if(n == 0 || w == 0) {
                   dp[n][w] = 0;
               }
           }
       }
       
       // critical section - choice diagram
       for(int n = 1; n < N+1; n++) {
           for(int w = 1; w < W+1; w++) {
               if(wt[n-1] <= w) {
                   dp[n][w] = max(val[n-1] + dp[n-1][w - wt[n-1]], dp[n-1][w]);
               }
               else {
                   dp[n][w] = dp[n-1][w];
               }
           }
       }
       
       return dp[N][W];
    }
};
