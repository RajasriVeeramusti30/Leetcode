class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] prev = new int[cols]; // dp for row i-1
        int count = 0;

        for (int i = 0; i < rows; i++) {
            int[] curr = new int[cols];
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) curr[j] = 1;
                    else curr[j] = Math.min(Math.min(prev[j], curr[j-1]), prev[j-1]) + 1;
                    count += curr[j];
                }
            }
            prev = curr;
        }
        return count;
    }
}
