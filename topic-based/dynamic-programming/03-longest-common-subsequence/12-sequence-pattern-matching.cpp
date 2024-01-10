// Question Link : https://leetcode.com/problems/is-subsequence/

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution {
public:
    bool isSubsequence(string s, string t) {
        int N = t.size();
        int M = s.size();
        vector<vector <int>> dp(N+1, vector<int>(M+1));

        for(int n =0; n < N+1; n++) {
            for(int m=0; m < M+1; m++) {
                if(n == 0 || m == 0) {
                    dp[n][m] = 0;
                }
            }
        }

        for(int n = 1; n < N+1; n++) {
            for(int m = 1; m < M+1; m++) {
                if(s[m-1] == t[n-1]) {
                    dp[n][m] = 1 + dp[n-1][m-1];
                }
                else {
                    dp[n][m] = max(dp[n-1][m], dp[n][m-1]);
                }
         
            }
        }



        return dp[N][M] == M;
    }
};