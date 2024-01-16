# Time Complexity: O(log(num))
# Auxiliary Space: O(1)

class Solution:
    INT_MAX = (2**31) -1
    def reverse(self, x: int) -> int:
        reversedNum = 0
        sign = -1 if x < 0 else 1
        x = abs(x)

        while(x != 0):
            remainder = x % 10
            x = x // 10 

            if (reversedNum > self.INT_MAX //10) or (reversedNum == self.INT_MAX//10 and remainder > 7):
                return 0
            
            reversedNum = reversedNum*10 + remainder

        return sign*reversedNum
        