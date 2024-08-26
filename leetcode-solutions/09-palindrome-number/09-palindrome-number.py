
# Time Complexity : 
# Space Complexity : 


class Solution:
    def reverseNumber(self, num: int) -> int:
        rev = 0
        while(num != 0 ):
            remainder = num % 10
            num = num // 10
            rev = rev*10 + remainder
        return rev

    def isPalindrome(self, x: int) -> bool:
        if x<0 :
            return False
        
        reversedNum = self.reverseNumber( x)

        return True if reversedNum == x else False
        