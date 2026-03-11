class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        
        int mask = 1;
        while (mask < n) {
            mask = (mask << 1) | 1; // Build mask of all 1s: 1 → 11 → 111 ...
        }
        
        return n ^ mask; // XOR with mask flips all bits
    }
}
