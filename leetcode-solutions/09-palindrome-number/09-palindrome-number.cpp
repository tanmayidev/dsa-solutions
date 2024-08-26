// Solution - Takes 7ms

/*
 Time Complexity : 
 Space Complexity : 
*/

class Solution {
public:

    long int reverseNum(int num) {

        long int reversedNum = 0;
        while(num != 0) {
            int remainder = num % 10;
            num = num / 10;
            reversedNum = reversedNum * 10 + remainder;
        }
        return reversedNum;
    }

    bool isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        
        long int reversedNum = reverseNum(x);
        return reversedNum == x ? true : false;
        
    }
};

// Solution  - Takes 3ms
class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        
        int num = x;
        int reversedNum = 0;
        while(x > 0) {
            int remainder = x % 10;
            x = x/10;

            if(reversedNum > INT_MAX/10 || (reversedNum == INT_MAX/10 && remainder > 7)){
                return false;
            }

            reversedNum = reversedNum*10 + remainder;
        }

        if(reversedNum == num) {
            return true;
        }
        else {
            return false;
        }
    }
};