// Question Link : https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution{
	public:
	int minOperations(string str1, string str2) 
	{ 
	    /*
	        To Convert string A to string B
	        Find LCS of A and B
	        A - LCS = number of deletions 
	        B - LCS = number of insertions
	        
	        Example: A = heap ; B = pea
	        LCS = ea
	        heap - ea = 2 (h and p are deleted)
	        pea - ea = 1 (p is inserted)
	    */
	    
	    int N = str1.size();
	    int M = str2.size();
	    int dp[N+1][M+1];
	    
	    for(int n=0; n < N+1; n++) {
	        for(int m=0; m < M+1; m++) {
	            if (n == 0 || m == 0) {
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
	                dp[n][m] = max( dp[n-1][m], dp[n][m-1]);
	            }
	        }
	    }
	    
	    int lcs = dp[N][M];
	    int numberOfInsertions = abs(M - lcs);
	    int numberOfDeletions = abs(N - lcs);
	    
	    return numberOfInsertions + numberOfDeletions;
	} 
};