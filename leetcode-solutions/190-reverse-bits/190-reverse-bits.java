public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // make space
            result |= (n & 1);     // add last bit of n
            n >>>= 1;              // unsigned shift right
        }
        
        return result;
    }
}


----------------------------------------------------------
/**
Instead of reversing bit by bit, we swap:
- 16-bit halves
- 8-bit blocks
- 4-bit blocks
- 2-bit blocks
- 1-bit blocks
 */

public class Solution {
    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}

// ----------------------------

// Caching

// public class Solution {
//     Map<Integer, Integer> cache = new HashMap<>();

//     public int reverseBits(int n) {
//         if (cache.containsKey(n)) return cache.get(n);
        
//         int result = 0;
//         int original = n;
        
//         for (int i = 0; i < 32; i++) {
//             result <<= 1;
//             result |= (n & 1);
//             n >>>= 1;
//         }
        
//         cache.put(original, result);
//         return result;
//     }
// }
