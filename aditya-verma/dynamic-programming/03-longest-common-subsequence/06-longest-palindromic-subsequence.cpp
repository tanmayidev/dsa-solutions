// Question Link - https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1

/*
 Time Complexity : 
 Space Complexity : 
*/

/**

S = "ABCBEDBA"

str1 = "ABCBEDBA"
str2 = str1.reverse()

Longest Palindromic Subsequence
LPS = LCS (str1, str2) = (str1, str1.reverse())

*/

class Solution{
  public:
    int longestPalinSubseq(string A) {
        int N = A.size(), M = A.size();
        string B = A;
        reverse(B.begin(), B.end());
        
        int dp[N+1][N+1];
        
        for(int n=0; n < N+1; n++) {
            for(int m=0; m < M+1; m++) {
                if(n==0 || m==0) {
                    dp[n][m] = 0;
                }
            }
        } 
        
        for(int n=1; n < N+1; n++) {
            for(int m=1; m < M+1; m++) {
                if(A[n-1] == B[m-1]) {
                    dp[n][m] = 1 + dp[n-1][m-1];
                }
                else {
                    dp[n][m] = max(dp[n-1][m], dp[n][m-1]);
                }
            }
        }
        
        return dp[N][M];
    }
};