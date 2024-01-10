// Question Link :  https://leetcode.com/problems/shortest-common-supersequence/description/

/*
 Time Complexity : 
 Space Complexity : 
*/

/**
Priting Shortest Common Supersequence

logic:

int n = N, m = M;
string resultStr = "";

while(n > 0 && m > 0) {
	if (str1[n-1] == str2[m-1]) {
		resultStr.push_back(str1[n-1]);
		n--;
		m--;
	} else if (dp[n-1][m] > dp[n][m-1) {
    resultStr.push_back(str1[n-1]);
		n--;
	} else {
    resultStr.push_back(str2[m-1]);
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


class Solution {
public:
    string shortestCommonSupersequence(string str1, string str2) {
        int N = str1.size();
        int M = str2.size();
        vector <vector<int>> dp(N+1, vector<int> (M+1));

        for(int n=0; n < N+1; n++) {
            for(int m=0; m < M+1; m++) {
                if(n == 0 || m == 0) {
                    dp[n][m] = 0;
                }
            }
        }

        for(int n=1; n < N+1; n++) {
            for(int m=1; m < M+1; m++) {
                if(str1[n-1] == str2[m-1]) {
                    dp[n][m] = 1+dp[n-1][m-1];
                } else {
                    dp[n][m] = max(dp[n-1][m], dp[n][m-1]);
                }
            }
        }

        int n = N;
        int m = M;
        string s = "";

        while(n != 0 && m != 0) {
            if(str1[n-1] == str2[m-1]) {
                s = str1[n-1] + s;
                n--;
                m--;
            }
            else if(dp[n-1][m] > dp[n][m-1]) {
                s = str1[n-1] + s;
                n--;
            } else {
                s = str2[m-1] + s;
                m--;
            }
        }

        while(n > 0) {
            s = str1[n-1] + s;
            n--;
        }

        while(m > 0) {
            s = str2[m-1] + s;
            m--;
        }
        
        return s;
    }
};