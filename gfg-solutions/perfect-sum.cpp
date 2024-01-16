// Question Link : https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

/*
 Time Complexity : 
 Space Complexity : 
*/

// Above problem but with constraints modified - 
/**
Constraints:
1 ≤ N*sum ≤ 106
1 ≤ arr[i] ≤ 106

*/

class Solution{

	public:
	int perfectSum(int arr[], int N, int sum)
	{
	    // create table
       int dp[N+1][sum+1];
       
       
       // initialize table with base condition
       for(int n = 0; n < N+1; n++) {
           for(int s = 0; s < sum+1; s++) {
               if(s == 0) {
                   dp[n][s] = 1;
               }
               else if(n == 0) {
                   dp[n][s] = 0;
               }
           }
       }
       
       // critical condition
       for(int n = 1; n < N+1; n++) {
           for(int s = 1; s < sum+1; s++) {
               if(arr[n-1] <= s) {
                   dp[n][s] = dp[n-1][s - arr[n-1]] + dp[n-1][s];
               }  
               else {
                   dp[n][s] = dp[n-1][s];
               }
           }
       }
       return dp[N][sum];
	}
	  
};