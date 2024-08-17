// Question Link : https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
// Above problem but with constraints modified - 

/*
 Time Complexity : 
 Space Complexity : 
*/

/**
Constraints:
1 ≤ N*sum ≤ 106
1 ≤ arr[i] ≤ 106


Explanation : 

Input
arr = [2, 3, 5, 6, 8, 10]
sum = 10

Output 
3 => [2,3,5] , [2,8], [10]

Tabulation

	0	1	2	3	4	5	6	7	8	9	10	11		2, 3, 5, 6, 8, 10
0	1	0	0	0	0	0	0	0	0	0	0			{}
1	1	0	1	0	0	0	0	0	0	0	0			{2}
2	1	0	1	1	0	1	0	0	0	0	0			{2,3}
3	1	0	1	1	0	2	0	1	1	0	1			{2,3,5}
4	1	0	1	1	0	2	1	1	2	1	1			{2,3,5,6}
5	1	0	1	1	0	2	1	1	3	1	2			{2,3,5,6,8}
6	1	0	1	1	0	2	1	1	3	1	3			{2,3,5,6,8,10}
7														


*/

class Solution{

	public:
	int perfectSum(int arr[], int N, int sum)
	{
	    // create table
       int dp[N+1][sum+1];
       
       
       // initialize table with base condition
       for(int n = 0; n < N+1; n++) {
           for(int s = 0; s < sum+1; s++) {
               if(s == 0) {
                   dp[n][s] = 1;
               }
               else if(n == 0) {
                   dp[n][s] = 0;
               }
           }
       }
       
       // critical condition
       for(int n = 1; n < N+1; n++) {
           for(int s = 1; s < sum+1; s++) {
               if(arr[n-1] <= s) {
                   dp[n][s] = dp[n-1][s - arr[n-1]] + dp[n-1][s];
               }  
               else {
                   dp[n][s] = dp[n-1][s];
               }
           }
       }
       return dp[N][sum];
	}

    int perfectSumWithConstraints(int arr[], int N, int sum)
  {
    // Using Tabulation
    int dp[n+1][sum+1];
    int mod=1e9 + 7;

    // Why initialization in two parts and not like two loops before?
    // 1. Usually we fill both first column i.e., sum == 0 and first row i.e., n == 0 with initial values
    // 2. Here, since constraints say that array can have 0 included, then possibilities to get sum == 0 changes
    // 3. Theoritically, when s == 0, the values in table should be 2^number of zeroes in processed array
    // 4. This condition is not base case, since answer changes, so this case is handled in choice diagram 
    // 5. To handle it in Choice diagram/ Critical section, just loop for sum starting from 0, since those values are not filled
         
    //Initialization
    for(int s =0 ; s< sum+1 ; s++)
      dp[0][s]=0; // when n == 0 (first row)
          
    //Why not initialization all i and j =0 with 1?
    // As, if the array contains single or multiple zero elements
    // then the number of subsets that sum to zero will increase.
          
    dp[0][0] = 1; // n==0 and s==0 i.e., nullset is possible
          
    for(int n = 1; n < N+1; i++)
    {
      for(int s = 0; s < sum+1; s++)
      {
        if(arr[i-1] <= s) 
        {
          // include that last number dp[i-1][j-arr[i-1]]
          // not include that last number dp[i-1][j]
          // we need to consider both the cases and add both values
                      
          dp[n][s] = (dp[n-1][s-arr[n-1]] % mod + dp[n-1][s] % mod)% mod;
          // why modulo? It is mentioned in the question to prevent overflow
          // why modulo after adding both cases? As, after addition the sum could overflow.
        }
        else
        {
          dp[n][s] = (dp[n-1][s])% mod;
        }
                  
      }
    }
          
    return dp[N][sum];
  }
	  
};