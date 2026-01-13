class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        for (int[] square : squares) {
            long side = square[2];
            totalArea += (double)side * side;
        }
        
        double target = totalArea / 2.0;
        
        Set<Double> pointsSet = new HashSet<>();
        for (int[] square : squares) {
            pointsSet.add((double)square[1]);
            pointsSet.add((double)(square[1] + square[2]));
        }
        
        List<Double> points = new ArrayList<>(pointsSet);
        Collections.sort(points);
        
        int left = 0, right = points.size() - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            double areaBelow = calculateAreaBelow(squares, points.get(mid));
            
            if (areaBelow < target - 1e-9) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        if (left == 0) {
            return points.get(0);
        }
        
        double y1 = points.get(left - 1);
        double y2 = points.get(left);
        double area1 = calculateAreaBelow(squares, y1);
        double area2 = calculateAreaBelow(squares, y2);
        
        if (Math.abs(area2 - area1) < 1e-9) {
            return y1;
        }
        
        return y1 + (target - area1) / (area2 - area1) * (y2 - y1);
    }
    
    private double calculateAreaBelow(int[][] squares, double h) {
        double area = 0;
        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];
            
            if (h <= y) {
                continue;
            } else if (h >= y + l) {
                area += (double)l * l;
            } else {
                double heightBelow = h - y;
                area += l * heightBelow;
            }
        }
        return area;
    }
}
