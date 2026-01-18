class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Build prefix sums for rows: rowSum[i][j] = sum of grid[i][0..j-1]
        int[][] rowSum = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
            }
        }
        
        // Build prefix sums for columns: colSum[i][j] = sum of grid[0..i-1][j]
        int[][] colSum = new int[m + 1][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }
        
        // Try each size from largest to smallest
        int maxK = Math.min(m, n);
        for (int k = maxK; k >= 1; k--) {
            // Try each possible top-left corner
            for (int r = 0; r <= m - k; r++) {
                for (int c = 0; c <= n - k; c++) {
                    if (isMagic(grid, rowSum, colSum, r, c, k)) {
                        return k;
                    }
                }
            }
        }
        
        return 1; // Single cell is always magic
    }
    
    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum, 
                            int r, int c, int k) {
        // Use first row sum as target
        int target = getRowSum(rowSum, r, c, k);
        
        // Check all rows
        for (int i = 1; i < k; i++) {
            if (getRowSum(rowSum, r + i, c, k) != target) {
                return false;
            }
        }
        
        // Check all columns
        for (int j = 0; j < k; j++) {
            if (getColSum(colSum, r, c + j, k) != target) {
                return false;
            }
        }
        
        // Check main diagonal (top-left to bottom-right)
        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != target) {
            return false;
        }
        
        // Check anti-diagonal (top-right to bottom-left)
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[r + i][c + k - 1 - i];
        }
        if (diag2 != target) {
            return false;
        }
        
        return true;
    }
    
    // Get sum of row i from column c to c+k-1
    private int getRowSum(int[][] rowSum, int i, int c, int k) {
        return rowSum[i][c + k] - rowSum[i][c];
    }
    
    // Get sum of column j from row r to r+k-1
    private int getColSum(int[][] colSum, int r, int j, int k) {
        return colSum[r + k][j] - colSum[r][j];
    }
}
