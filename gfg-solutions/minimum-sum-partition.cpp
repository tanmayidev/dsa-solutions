// Question Link : https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution{

  public:
	int minDifference(int arr[], int N)  { 
	    
	    int sum = 0;
	    for(int i = 0; i < N ; i++ ) {
	        sum += arr[i];
	    }
	    
	    bool dp[N+1][sum+1];
	    
	    // subset sum
	   for(int s=0; s < sum+1; s++) {
	       dp[0][s] = false;
	   }
	        
	  dp[0][0] = true;
	    
	    
	    for(int n=1; n < N+1; n++) {
	        for(int s=0; s < sum+1; s++) {
	            if(arr[n-1] <= s) {
	                dp[n][s] = dp[n-1][s - arr[n-1]] || dp[n-1][s];
	            }
	            else {
	                dp[n][s] = dp[n-1][s];
	            }
	        }
	    }
	    
	    vector<int> rangeArr;
	    for(int i=0; i< (sum/2)+1; i++) {
	        if(dp[N][i]) {
	            rangeArr.push_back(i);
	        }
	    }
	    
	    int minDiff = INT_MAX;
	    for(int i = 0; i < rangeArr.size(); i++ ) {
	        minDiff = min(minDiff, sum - 2*rangeArr[i]);
	    }
	    
	    return minDiff;
	} 
};
