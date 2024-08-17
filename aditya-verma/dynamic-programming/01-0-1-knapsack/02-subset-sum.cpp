// Question Link : https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

/*
 Time Complexity : 
 Space Complexity : 
*/

// Final Solution
class Solution{   
public:
    bool evaluateSubsetSum(vector<int>arr, int N, int sum) {
       // create tabulation
        bool dp[N+1][sum+1];
        
        // initialize the tabulation with base condition
        for(int n=0; n< N+1; n++) {
            for(int s=0; s< sum+1; s++) {
                if(s == 0) {
                    dp[n][s] = true;
                }
                if(n==0 && s!=0) { // else if(n==0)
                    dp[n][s] = false;
                }
            }
        }
        
        // evaluate the critical section
        for(int n=1; n< N+1; n++) {
            for(int s=1; s< sum+1; s++) {
                if(arr[n-1] <= s) {
                    dp[n][s] = dp[n-1][s - arr[n-1]] || dp[n-1][s];
                }
                else {
                    dp[n][s] = dp[n-1][s];
                }
            }
        }
        
        return dp[N][sum];
        
    }
    

    bool isSubsetSum(vector<int>arr, int sum){
        int N = arr.size();
        return evaluateSubsetSum(arr, N, sum);
    }
};


// All Solutions


class Solution{   
public:
  
    // Best Solution - Iterative
    bool iterativeSol(vector<int>arr, int n, int sum) {
        bool dp[n+1][sum+1];
        
        for(int i=0; i< n+1; i++) {
            for(int j=0; j< sum+1; j++) {
                if(j == 0) {
                    dp[i][j] = true;
                }
                if(i==0 && j!=0) {  // else if(i==0)
                    dp[i][j] = false;
                }
            }
        }
        
        for(int i=1; i< n+1; i++) {
            for(int j=1; j< sum+1; j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
        
    }
    
    // Next Best - Memoized Sol
    // This is not working - fix later
    bool memoizedSol(vector<int>arr, int n, int sum, int memo[][10001]) {
        if(sum == 0) {
            return true;
        }
        
        if(n == 0 && sum !=0) {  // else if(n==0)
            return false;
        }
        
        if(memo[n][sum] != -1) {
            return (bool)(memo[n][sum]);
        }
        
        
        if(arr[n-1] <= sum ) {
            return memo[n][sum] = (int)(memoizedSol(arr, n-1, sum-arr[n-1], memo) || memoizedSol(arr, n-1, sum, memo));
        }
        else {
            return memo[n][sum] = (int)(memoizedSol(arr, n-1, sum, memo));
        }
    }
  
    // recursive
    bool recursiveSol(vector<int>arr, int n, int sum) {
        if(sum == 0) {
            return true;
        }
        
        if(n == 0 && sum !=0) { // else if(n==0)
            return false;
        }
        
        
        if(arr[n-1] <= sum ) {
            return recursiveSol(arr, n-1, sum-arr[n-1]) || recursiveSol(arr, n-1, sum);
        }
        else {
            return recursiveSol(arr, n-1, sum);
        }
    }

    bool isSubsetSum(vector<int>arr, int sum){
        int n = arr.size();
        // int memo[n+1][sum+1];
        // memset(memo, -1, sizeof(memo));
        
        // return memoizedSol(arr, n, sum, memo);
        
        return iterativeSol(arr, n, sum);
    }
};