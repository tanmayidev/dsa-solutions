// Question Link
// HR - https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem

/*
 Time Complexity : 
 Space Complexity : 
*/

/**
Priting Longest Common Subsequence

logic:

int n = N, m = M;
string resultStr = "";

while(n > 0 && m > 0) {
	if (str1[n-1] == str2[m-1]) {
		resultStr = str1[n-1] + resultStr;
		n--;
		m--;
	} else if (dp[n-1][m] >= dp[n][m-1) {
		n--;
	} else {
		m--;
	}
}

Example: 

n = 5, m = 6 => resultStr = "f",
n = 4, m = 5 => (m--)
n = 4, m = 4 => (m--)
n = 4, m = 3 => "cf"
n = 3, m = 2 => "bcf"
n = 2, m = 1 => (n--)
n = 1, m = 1 => "abcf"
n = 0, m = 0 => break

return resultStr
*/


vector<int> longestCommonSubsequence(vector<int> a, vector<int> b) {
    const int N = a.size();
    const int M = b.size();
    
    vector<vector<int>> dp(N+1, vector<int>(M+1));
    
    for (int n = 0; n < N+1; n++) {
        for (int m = 0; m < M+1; m++) {
            dp[n][m] = 0;
        }
    }
    
    for (int n = 1; n < N+1; n++) {
        for (int m = 1; m < M+1; m++) {
            if (a[n-1] == b[m-1]) {
                dp[n][m] = 1 + dp[n-1][m-1];
            } else {
                dp[n][m] = max(dp[n-1][m], dp[n][m-1]);
            }
        }
    }
    
    int n = N;
    int m = M;
    vector<int> result;
    
    while (n > 0 && m > 0) {
        if (a[n-1] == b[m-1]) {
            result.push_back(a[n-1]);
            n--;
            m--;
        } else if (dp[n-1][m] > dp[n][m-1]) {
            n--;
        } else {
            m--;
        }
    }
    
    reverse(result.begin(), result.end());
    
    return result;
}