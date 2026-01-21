class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            ans[i] = findMinBitwise(num);
        }
        
        return ans;
    }
    
    private int findMinBitwise(int num) {
        // Special case: if num is 2, it's impossible
        // 0 OR 1 = 1, 1 OR 2 = 3, no way to get 2
        if (num == 2) {
            return -1;
        }
        
        // Find the rightmost 0 bit in num
        // This tells us where the rightmost group of 1s ends
        int pos = 0;
        while (pos < 31 && (num & (1 << pos)) != 0) {
            pos++;
        }
        
        // Turn off the bit just before this 0 (the rightmost bit of rightmost 1s group)
        // This gives us the minimum x
        return num ^ (1 << (pos - 1));
    }
}
