// Question Link : https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution
{
    public:
    //Function to find the length of longest common subsequence in two strings.
    int lcs(int N, int M, string s1, string s2)
    {
        int dp[N+1][M+1];
        
        for(int n =0 ; n < N+1 ; n++) {
            for(int m = 0; m < M+1; m++) {
                if(n == 0 || m == 0) { // if any of string is 0, then lcs is 0
                    dp[n][m] = 0;
                }
            }
        }
        
        for(int n=1; n < N+1; n++) {
            for(int m=1; m < M+1; m++) {
              // if match is found then we increase count by 1
                if(s1[n-1] == s2[m-1]) {
                    dp[n][m] = 1 + dp[n-1][m-1];
                }
                // if match is not found, then max of both options
                else {
                    dp[n][m] = max(dp[n-1][m] ,  dp[n][m-1]);
                }
            }
        }
        
        return dp[N][M];
    }
};