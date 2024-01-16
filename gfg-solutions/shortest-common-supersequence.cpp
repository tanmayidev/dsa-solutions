// Question Link : https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution
{
    public:
    //Function to find length of shortest common supersequence of two strings.
    int shortestCommonSupersequence(string S1, string S2, int N, int M)
    {
        int dp[N+1][M+1];
        
        // N + M = longest supersequence
        // N + M - (Longest Common Subsequence) = Shortest Supersequence
        
        // base condition
        for(int n = 0; n < N+1; n++) {
            for(int m = 0; m < M+1; m++) {
                if(n == 0 || m == 0) {
                    dp[n][m] = 0;
                }
            }
        }
        
        // critical section
        for(int n = 1; n < N+1; n++) {
            for(int m = 1; m < M+1; m++) {
                if(S1[n-1] == S2[m-1]) {
                    dp[n][m] = 1 + dp[n-1][m-1];
                }
                else {
                    dp[n][m] = max (dp[n-1][m], dp[n][m-1]);
                }
            }
        }
        
        return ((N+M)-dp[N][M]);
    }
};