// Question Link - https://www.geeksforgeeks.org/problems/find-length-of-longest-subsequence4905/1

/*
 Time Complexity : 
 Space Complexity : 
*/

/**
Explanation :

Subsequence - can be discontinous
Substring - cannot be discontinous

	0	1	2	3	4	5	6	7
X	a	b	c	d
Y	b	a	c	d	b	d	c	d


i = 0, j = 0:
a != b
(i++/j++)

CASE 1 :

1. i = 1, j = 0
b == b
result = 1
i++, j++

i = 2, j = 1
c != a // Whenever not equals condition comes - DO NOT INCREMENT j (substring in Y - it should not be discontinous)
i++

i = 3, j = 1
d != a
result = 1

---------------
CASE 2 : 

2. i = 0, j = 1
a == a
result = 1
i++, j++

i = 1, j = 2
b != c // Whenever not equals condition comes - DO NOT INCREMENT j (substring in Y - it should not be discontinous)
i++

i = 2, j = 2
result = 2
i++, j++

i = 3, j = 3
result = 3
i++, j++


*/

int maxSubsequenceSubstring(string X, string Y, int N, int M){
    //code
    
    vector<vector<int>> dp(N+1, vector<int>(M+1));
    
    for (int n = 0; n < N+1; n++) {
        for (int m = 0; m < M+1; m++) {
            if (n == 0 || m == 0) {
                dp[n][m] = 0;
            }
        }
    }
    
    int rv = 0;
    
    for (int n = 1; n < N+1; n++) {
        for (int m = 1; m < M+1; m++) {
            if (X[n-1] == Y[m-1]) {
                dp[n][m] = 1 + dp[n-1][m-1];
                rv = dp[n][m] > rv ? dp[n][m] : rv;
            } else {
                dp[n][m] = dp[n-1][m]; // Remove the condition for string Y
            }
        }
    }
    
    return rv;
    
}