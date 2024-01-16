// Question Link : https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1

// NOTE: 371 is an Armstrong number since 33 + 73 + 13 = 371

/*
 Time Complexity : 
 Space Complexity : 
*/

// Recursive Solution

class Solution {
  public:
    int evaluate(int n) {
        if (n == 0) {
            return 0;
        }
        if (n > 0) {
            return (pow(n%10, 3) + evaluate(floor(n/10)));
        }
    }

    string armstrongNumber(int n){
        return n == evaluate(n) ? "Yes" : "No";
    }
};

// Iterative Solution
class Solution {
  public:
    int evaluate(int num) {
        int result = 0;
        while(num != 0) {
            int currentDigit = num % 10;
            num = num/10;
            result += pow(currentDigit , 3);
        }
        return result;
    }
    
    string armstrongNumber(int n){
        int ans = evaluate(n);
        
        return ans == n ? "Yes" : "No";
    }
};