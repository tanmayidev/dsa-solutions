class Solution {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int res = -1;
            int d = 1;
            while ((x & d) != 0) {
                res = x - d;
                d <<= 1;
            }
            result[i] = res;
        }
        return result;
    }
}

---------

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int j = 0; j < n; j++) {
            int x = nums.get(j);
            
            if (x == 2) {
                ans[j] = -1;
            } else {
                // Find the lowest 0-bit position (starting from bit 1)
                for (int i = 1; i < 32; i++) {
                    if (((x >> i) & 1) == 0) {
                        // Clear the bit at position (i - 1)
                        ans[j] = x ^ (1 << (i - 1));
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}
