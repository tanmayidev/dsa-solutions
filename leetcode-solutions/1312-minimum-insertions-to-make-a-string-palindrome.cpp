// Question Link - https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution {
public:
    int minInsertions(string s1) {
        string s2 = s1;
        reverse(s2.begin(), s2.end());

        int N = s1.size();
        int M = s2.size();

        vector<vector <int>> dp(N+1, vector<int> (M+1));

        for(int n=0; n < N+1; n++) {
            for(int m=0; m < M+1; m++) {
                if(n == 0 || m == 0) {
                    dp[n][m] = 0;
                }
            }
        }

        for(int n=1; n < N+1; n++) {
            for(int m=1; m < M+1; m++) {
                if(s1[n-1] == s2[m-1]) {
                    dp[n][m] = 1 + dp[n-1][m-1];
                }
                else {
                    dp[n][m] = max(dp[n-1][m] , dp[n][m-1]);
                }
            }
        }

        return N - dp[N][M];
    }
};