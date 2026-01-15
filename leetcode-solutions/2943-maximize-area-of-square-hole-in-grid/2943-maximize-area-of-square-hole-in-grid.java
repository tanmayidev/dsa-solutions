class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // Find the maximum consecutive bars in horizontal and vertical arrays
        int maxH = findMaxConsecutive(hBars);
        int maxV = findMaxConsecutive(vBars);
        
        // The side length of the square hole is the minimum of the two
        // (since we need both horizontal and vertical bars to form a square)
        // We add 1 because removing k consecutive bars creates k+1 gaps
        int side = Math.min(maxH, maxV) + 1;
        
        // Return the area
        return side * side;
    }
    
    private int findMaxConsecutive(int[] bars) {
        // Sort the array first
        Arrays.sort(bars);
        
        int maxConsecutive = 1;
        int currentConsecutive = 1;
        
        // Find the longest sequence of consecutive numbers
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentConsecutive++;
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
            } else {
                currentConsecutive = 1;
            }
        }
        
        return maxConsecutive;
    }
}
