// Solution take 43 ms
// Time complexity : O(n * sqrt(k)), n is nums length, k is the largest number in nums array
class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            int numOfFactors = 0;
            int sumOfFactors = 0;
            int num = nums[i];
            int roundedSqrt = (int)(Math.sqrt(num));

            for (int j = 1; j <= roundedSqrt; j++) {
                if (num % j == 0) {
                    numOfFactors++;
                    sumOfFactors += j;

                    if ((num / j) != j) {
                        numOfFactors++;
                        sumOfFactors += (num/j);
                    }
                }
            }

            if (numOfFactors == 4) {
                sum += sumOfFactors;
            }
        }

        return sum;
    }
}


// Below is the solution that takes has takes 114ms
// Time complexity : O(n * (sqrt(k) + O(4)), n is nums length, k is the largest number in nums array
// Overhead : ArrayList, extra iteration over array

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        int n = nums.length - 1;

        while (n >= 0) {
            // Reason: we do not know the number of divisors, so no fixed length
            List<Integer> temp = new ArrayList<>();

            for (int i = 1; i <= Math.floor(Math.sqrt(nums[n])); i++) {
                if (nums[n] % i == 0) {
                    temp.add(i);
                    if(nums[n] /i != i) {
                        temp.add(nums[n] / i);
                    }
                }
            }

            if (temp.size() == 4) {
                for (int j = 0; j < 4; j++) {
                    result += temp.get(j);
                }
            }
            n--;
        }

        return result;
    }
}

