// Question Link - https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

/*
 Time Complexity : 
 Space Complexity : 
*/

/**

Example: 

Input : S = "AABCBDED"
Output : 3 which is "ABD"

Explanation : 
S1 = "AABCBDED"
S2 = "AABCBDED"

0 1 2 3 4 5 6 7 
A A B C B D E D
A A B C B D E D
0 1 2 3 4 5 6 7

when 3==3 or 6==6 you exclude it

Here C and E should not be considered when taking LCS
Because, there are not repeated in the same string twice

This can be done by excluding the characters which are at the same index in S1 and S2

*/

class Solution {
	public:
		int LongestRepeatingSubsequence(string str1){
		    string str2 = str1;
		    int N = str1.size();
		    int M = N;
		    int dp[N+1][M+1];
		    
		    for(int n=0; n < N+1; n++) {
		        for(int m=0; m < M+1; m++) {
		            if(n==0 || m==0) {
		                dp[n][m] = 0;
		            }
		        }
		    }
		    
		    for(int n = 1; n < N+1; n++) {
		        for(int m=1; m < M+1; m++) {
              // important thing is n!=m
		            if(str1[n-1] == str2[m-1] && n != m) {
		                dp[n][m] = 1 + dp[n-1][m-1];
		            }
		            else {
		                dp[n][m] = max( dp[n-1][m] , dp[n][m-1]);
		            }
		        }
		    }
		    
		    return dp[N][M];
		}

};