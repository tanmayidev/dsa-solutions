
/**

Time Complexity: O(log(num))
Auxiliary Space: O(1)

*/

/*

INT_MAX = 2147483647
INT_MIN = -2147483648

Example: x = 123

rev=0
rem = 123%10 = 3
x = 123 / 10 = 12
rev = 0*0 + 3

rev = 3
rem = 12 % 10 = 2
x = 12 /10 = 1
rev = 3*10 + 2

rev = 32
rem = 1 % 10 = 1
x = 1 / 10 = 0
rev = 32*10 + 1

rev = 321


*/

class Solution {
public:
    int reverse(int x) {
        int rev = 0;

        while(x != 0) {
            int rem = x%10;
            x /= 10;

            if(rev > INT_MAX/10 || (rev == INT_MAX/10 && rem > 7)) {
                return 0;
            }

            if (rev < INT_MIN/10 || (rev == INT_MIN/10 && rem < -8)) {
                return 0;
            }

            rev = rev*10 + rem;
        }

        return rev;
    }
};