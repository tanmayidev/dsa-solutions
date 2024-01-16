# Question Link : https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1

# Time Complexity : 
# Space Complexity : 

# Iterative Solution

class Solution:
    def evaluate(self, num):
        res = 0
        while(num!=0):  
            currentDigit = num%10
            num = num//10
            res = res+ currentDigit**3
        
        return res
        
    def armstrongNumber (self, n):
        result = self.evaluate(n)
        return "Yes" if result == n else "No"