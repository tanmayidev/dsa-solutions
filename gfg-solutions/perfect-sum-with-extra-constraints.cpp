// Question Link : https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution{
public:
  int perfectSum(int arr[], int N, int sum)
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
}