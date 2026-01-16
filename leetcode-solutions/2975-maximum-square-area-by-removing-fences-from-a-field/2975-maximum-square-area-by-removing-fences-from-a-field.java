class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1_000_000_007;
        
        // Get all possible horizontal gaps
        Set<Integer> hGaps = getAllGaps(m, hFences);
        
        // Get all possible vertical gaps
        Set<Integer> vGaps = getAllGaps(n, vFences);
        
        // Find the maximum common gap (which forms a square)
        int maxSide = -1;
        for (int gap : hGaps) {
            if (vGaps.contains(gap)) {
                maxSide = Math.max(maxSide, gap);
            }
        }
        
        if (maxSide == -1) {
            return -1;
        }
        
        long area = (long) maxSide * maxSide;
        return (int) (area % MOD);
    }
    
    private Set<Integer> getAllGaps(int boundary, int[] fences) {
        Set<Integer> gaps = new HashSet<>();
        
        // Create a list of all positions (including boundaries)
        List<Integer> positions = new ArrayList<>();
        positions.add(1); // Start boundary
        positions.add(boundary); // End boundary
        
        for (int fence : fences) {
            positions.add(fence);
        }
        
        // Sort positions
        Collections.sort(positions);
        
        // Calculate all possible gaps between any two positions
        for (int i = 0; i < positions.size(); i++) {
            for (int j = i + 1; j < positions.size(); j++) {
                gaps.add(positions.get(j) - positions.get(i));
            }
        }
        
        return gaps;
    }
}
