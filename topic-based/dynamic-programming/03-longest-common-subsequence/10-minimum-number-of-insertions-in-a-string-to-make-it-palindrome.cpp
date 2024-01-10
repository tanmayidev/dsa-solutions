// Question Link - https://www.geeksforgeeks.org/problems/form-a-palindrome2544/1

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
    number of deletions = str.size() - LPS 

    The elements that you have deleted can be inserted in original string to make it palindrome
    number of deletions = str.size() - LPS 

    Example : 
    str1 = "aebcbda"
    str2 = "adbcbea" = reverse of str1
    LPS = abcba = LCS (str1, str2)

    str1 - LPS = "ed" 

    - Deleted "ed" in str2 will give make str2 a palindrome
    - Inserting "ed" in str2 will make it a palindrome


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