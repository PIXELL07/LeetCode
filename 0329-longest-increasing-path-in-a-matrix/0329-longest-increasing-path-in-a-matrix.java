class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int[][] dp = new int[m][n];

        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if(dp[i][j] != 0) return dp[i][j];

        int maxLen = 1;

        for(int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            if(ni >= 0 && nj >= 0 && ni < m && nj < n 
               && matrix[ni][nj] > matrix[i][j]) {

                maxLen = Math.max(maxLen, 1 + dfs(matrix, ni, nj, dp));
            }
        }

        return dp[i][j] = maxLen;
    }
}