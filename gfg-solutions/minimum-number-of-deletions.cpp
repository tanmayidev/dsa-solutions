// Question Link - https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1

/*
 Time Complexity : 
 Space Complexity : 
*/

int minDeletions(string str1, int N) { 
    int M  = N;
    string str2 = str1;
    reverse(str2.begin(), str2.end());
    int dp[N+1][M+1];
    
    /*
    Longest Panlindromic Subsequence = LCS(str, reverse(str));
    str.size() - LPS = number of deletions
    */
    
    for(int n=0; n < N+1; n++) {
        for(int m=0; m < M+1; m++) {
            if(n ==0 || m==0) {
                dp[n][m] = 0;
            }
        }
    }
    
    for(int n=1; n < N+1; n++) {
        for(int m=1; m < M+1; m++) {
            if(str1[n-1] == str2[m-1]) {
                dp[n][m] = 1 + dp[n-1][m-1];
            }
            else {
                dp[n][m] = max(dp[n-1][m], dp[n][m-1]);
            }
        }
    }
    
    return N - dp[N][M];
}