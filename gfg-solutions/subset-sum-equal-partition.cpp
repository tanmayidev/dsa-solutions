// Question Link : https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution{
public:
    bool evaluateSubsetSum(int arr[], int N, int sum) {
        bool dp[N+1][sum+1];
        // Base Condition
       for(int n=0; n< N+1; n++) {
           for(int s=0; s < sum+1; s++) {
               if(s == 0) { // sum ==0 means we found partition
                   dp[n][s] = true;
               }
               // else if(n==0)
               if(n == 0 && s!=0) { // N == 0 means that array is empty
                   dp[n][s] = false;
               }
           }
       }
       
       for(int n= 1; n< N+1; n++) {
           for(int s=1; s< sum+1; s++) {
               if(arr[n-1] <= s) { // value in arr is lesser than sum we are looking for
                   dp[n][s] = dp[n-1][s - arr[n-1]] || dp[n-1][s]; // we include || we exclude
               }
               else {
                   dp[n][s] = dp[n-1][s];
               }
           }
       }
       
       return dp[N][sum];
    }

    int equalPartition(int N, int arr[])
    {
        // Check if Sum is even or not
        int sum = 0;
        for(int x = 0; x < N; x++) {
            sum += arr[x];
        }
        
        if(sum % 2 != 0 ) { // sum is odd
            return 0;
        }
        
        // if sum is Even, then we need to find if one partition exists and return True
        // Below part is same as Subset sum problem
        
        return evaluateSubsetSum(arr, N , sum/2) ? 1 : 0;
    }
};