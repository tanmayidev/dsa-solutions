// Question Link : https://www.geeksforgeeks.org/problems/rod-cutting0840/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution{
  public:
    int cutRod(int price[], int N) {
        // create pieces array
        // prices = vals
        // N = capacity
        // items = pieces.size
        
        // create pieces array
        vector<int> pieces;
        for(int p=1; p <= N; p++) {
            pieces.push_back(p);
        }
        
        // number of items
        int items = pieces.size();
        
        vector<vector<int>> dp(items+1, vector<int>(N+1));
        
        // base condition
        for(int i=0; i< items+1; i++) {
            for(int n=0; n < N+1; n++) {
                if(i == 0 || n == 0) {
                    dp[i][n] = 0;
                }
            }
        }
        
        // critical section
        
        for(int i = 1; i < items+1; i++) {
            for(int n = 1; n < N+1; n++) {
                if(pieces[i-1] <= n) {
                    dp[i][n] = max((price[i-1] + dp[i][n - pieces[i-1]]), dp[i-1][n]  );
                }
                else {
                    dp[i][n] = dp[i-1][n];
                }
            }
        }
        
        return dp[items][N];
    }
};