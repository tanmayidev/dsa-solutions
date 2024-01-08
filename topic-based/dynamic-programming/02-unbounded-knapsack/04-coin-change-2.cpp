// Question Link : https://www.geeksforgeeks.org/problems/number-of-coins1824/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution{

	public:
	int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    vector<vector<int>> dp(M+1, vector<int>(V+1));
      int INFINITY = INT_MAX - 1;
	    // M is size of coins array
	    // V is the target sum
	    
	    // when M=0 then initialize by INT_MAX-1
	    // when V == 0 and M != 0 then initialize by 0
	    // 2nd row -> v is divisible by coins[0] then v/coins[0] else INT_MAX-1
	    
	    for(int v=0; v <V+1 ; v++) {
	        dp[0][v] = INFINITY;
	    }
	    
	    for(int m=1; m < M+1; m++) {
	        dp[m][0] = 0;
	    }
	    
	    for(int v=1; v< V+1; v++) {
	        if(v%coins[0] == 0) {
	            dp[1][v] = v/coins[0];
	        }
	        else {
	            dp[1][v] = INFINITY;
	        }
	    }
	    
	    for(int m=2; m < M+1; m++) {
	        for(int v=1; v < V+1; v++) {
	            if(coins[m-1] <= v) {
	                dp[m][v] = min( 1+dp[m][v - coins[m-1]], dp[m-1][v] );
	            }
	            else {
	                dp[m][v] = dp[m-1][v];
	            }
	        }
	    }
	    
	    int ans = (dp[M][V] == INFINITY) ? -1 : dp[M][V];
	    return ans;
 	    
	} 
	  
};