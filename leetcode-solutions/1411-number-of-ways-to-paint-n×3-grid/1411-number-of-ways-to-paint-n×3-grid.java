/*
Hint : Checkout the Image
*/

class Solution {
    public int numOfWays(int n) {
        final int MOD = 1000000007;
        
        long countA = 6;
        long countB = 6;
        
        for (int i = 2; i <= n; i++) {
            long newA = (countA * 3 + countB * 2) % MOD;
            long newB = (countA * 2 + countB * 2) % MOD;
            
            countA = newA;
            countB = newB;
        }
        
        return (int)((countA + countB) % MOD);
    }
}
