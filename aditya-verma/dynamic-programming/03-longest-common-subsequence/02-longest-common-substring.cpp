// Question Link : https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution{
    public:
    
    int longestCommonSubstr (string S1, string S2, int N, int M)
    {
       int dp[N+1][M+1];
       int result = 0;
       
       for(int n=0; n < N+1; n++) {
           for(int m=0; m < M+1; m++){
               if(n == 0 || m == 0) {
                   dp[n][m] = 0;
               }
           }
       }
       
       for(int n=1; n < N+1; n++) {
           for(int m=1; m < M+1; m++) {
               if(S1[n-1] == S2[m-1]) {
                   dp[n][m] = 1 + dp[n-1][m-1]; 
                   // the max value can be anywhere in matrix, since we initialize to 0 in else block
                   result = dp[n][m] > result ? dp[n][m] : result;
               }
               else {
                   dp[n][m] = 0;
               }
               
           }
       }
       
       return result;
    }
};