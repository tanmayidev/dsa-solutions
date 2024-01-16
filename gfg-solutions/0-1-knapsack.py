# Question Link : https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1


# Time Complexity : 
# Space Complexity : 

class Solution:
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, N):
       dp = [[0 for _ in range(W + 1)] for _ in range(N + 1)]
       
       for n in range(N+1):
           for w in range(W+1):
               if n==0 or w==0:
                   dp[n][w] = 0
                   
       for n in range (1, N+1):
           for w in range(1, W+1):
               if(wt[n-1] <= w):
                   dp[n][w] = max((val[n-1] + dp[n-1][w - wt[n-1]]), dp[n-1][w] )
               else:
                   dp[n][w] = dp[n-1][w]
        
       return dp[N][W]
