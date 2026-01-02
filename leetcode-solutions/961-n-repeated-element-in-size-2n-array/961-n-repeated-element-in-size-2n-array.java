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
