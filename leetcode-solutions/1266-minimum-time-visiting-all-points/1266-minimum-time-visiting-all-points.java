class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        
        // Iterate through consecutive pairs of points
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];
            
            // Calculate horizontal and vertical distances
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            
            // Time needed is the maximum of the two distances
            totalTime += Math.max(dx, dy);
        }
        
        return totalTime;
    }
}
