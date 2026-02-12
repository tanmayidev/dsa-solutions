class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int start = 0; start < n; start++) {
            int[] freq = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for (int end = start; end < n; end++) {
                int index = s.charAt(end) - 'a';

                if (freq[index] == 0) {
                    distinct++;
                }

                freq[index]++;
                maxFreq = Math.max(maxFreq, freq[index]);

                int length = end - start + 1;

                if (length == distinct * maxFreq) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}
