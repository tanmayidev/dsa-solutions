class Solution {
    private static int MAX_POWER_OF_3 = 1_162_261_467;

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else {
            return MAX_POWER_OF_3 % n == 0 ? true : false;
        }
    }
}
