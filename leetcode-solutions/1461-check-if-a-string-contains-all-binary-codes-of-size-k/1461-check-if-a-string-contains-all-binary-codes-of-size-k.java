class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) return false;
        
        Set<String> seen = new HashSet<>();
        int need = 1 << k; // 2^k
        
        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));
            if (seen.size() == need) return true; // early exit
        }
        
        return seen.size() == need;
    }
}
