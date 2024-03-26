# Question Link : https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1


class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
       dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]
       
       for i in range(n+1):
           for j in range(W+1):
               if i==0 or j==0:
                   dp[i][j] = 0
                   
       for i in range (1, n+1):
           for j in range(1, W+1):
               if(wt[i-1] <= j):
                   dp[i][j] = max((val[i-1] + dp[i-1][j - wt[i-1]]), dp[i-1][j] )
               else:
                   dp[i][j] = dp[i-1][j]
        
       return dp[n][W]
