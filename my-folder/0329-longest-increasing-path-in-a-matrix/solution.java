class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] cache = new int[n][m];
        for (int[] c : cache) Arrays.fill(c, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, cache));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];

        int[][] dirs = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        int ans = 1;
        for(int[] d : dirs) {
            int dx = d[0];
            int dy = d[1];
            int nx = i + dx;
            int ny = j + dy;
            if (isBounded(matrix, nx, ny) && matrix[nx][ny] > matrix[i][j])
                ans = Math.max(ans, 1 + dfs(matrix, nx, ny, cache));
        }
        cache[i][j] = ans;
        return ans;
    }


    public boolean isBounded(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int m = matrix[0].length;
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
