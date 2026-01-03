// Array Length = 2*n
// Number of unique elements = n + 1
// Note : Find the element repeated n times
// Since unique number of elements are n+1, the remaining elements of the array should be the specific number that needs to be repeated n times
// any number thats repeated more than once will be the answer
/*
Examples : 
len(nums) = 8
n = 4
unique elements = 5
nums = [1, 2, 3, 4, 5, 5, 5, 5]
*/

class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;

        HashMap<Integer, Boolean> freq = new HashMap<Integer, Boolean>(n + 1);

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];

            if (freq.containsKey(element)) {
                return element;
            } else {
                freq.put(element, true);
            }
        }

        return -1;
    }
}
