class Solution {
    public int longestBalanced(String s) {
        char[] cs = s.toCharArray();
        int x = calc1(cs);  // single character case
        int y = Math.max(calc2(cs, 'a', 'b'), 
                Math.max(calc2(cs, 'b', 'c'), calc2(cs, 'a', 'c')));  // two character cases
        int z = calc3(cs);  // three character case
        return Math.max(x, Math.max(y, z));
    }
    
    // Case 1: Single character balanced substring
    private int calc1(char[] s) {
        int res = 0;
        int i = 0, n = s.length;
        while (i < n) {
            int j = i + 1;
            while (j < n && s[j] == s[i]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }
    
    // Case 2: Two character balanced substring
    private int calc2(char[] s, char a, char b) {
        int res = 0;
        int i = 0, n = s.length;
        while (i < n) {
            // Skip characters that are not a or b
            while (i < n && s[i] != a && s[i] != b) {
                i++;
            }
            
            // Use hashmap to track difference between counts of a and b
            Map<Integer, Integer> pos = new HashMap<>();
            pos.put(0, i - 1);  // initial position for diff = 0
            int d = 0;
            
            while (i < n && (s[i] == a || s[i] == b)) {
                d += (s[i] == a) ? 1 : -1;
                if (pos.containsKey(d)) {
                    res = Math.max(res, i - pos.get(d));
                } else {
                    pos.put(d, i);
                }
                i++;
            }
        }
        return res;
    }
    
    // Case 3: Three character balanced substring
    private int calc3(char[] s) {
        Map<String, Integer> pos = new HashMap<>();
        pos.put("0,0", -1);  // initial state
        int[] cnt = new int[3];  // count for 'a', 'b', 'c'
        int res = 0;
        
        for (int i = 0; i < s.length; i++) {
            cnt[s[i] - 'a']++;
            // Key: (cnt[a] - cnt[b], cnt[b] - cnt[c])
            String key = (cnt[0] - cnt[1]) + "," + (cnt[1] - cnt[2]);
            if (pos.containsKey(key)) {
                res = Math.max(res, i - pos.get(key));
            } else {
                pos.put(key, i);
            }
        }
        return res;
    }
}
