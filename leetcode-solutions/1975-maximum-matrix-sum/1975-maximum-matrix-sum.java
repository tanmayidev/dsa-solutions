class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sumOfElements = 0;
        int n = matrix.length, numOfNegativeNumbers = 0, leastElement = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(matrix[i][j] < 0) {
                    numOfNegativeNumbers++;
                }

                int element = Math.abs(matrix[i][j]);
                if(element < leastElement) {
                    leastElement = element;
                }

                sumOfElements = (long)element + sumOfElements;
            }
        }
        // even
        if((numOfNegativeNumbers & 1) != 1) {
            return sumOfElements;
        } else {
            return sumOfElements - (2* leastElement);
        }
        
    }
}
