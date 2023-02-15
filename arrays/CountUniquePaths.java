public class CountUniquePaths {

    /**
     * Assume a grid of dimensions m x n.
     * @return the number of paths to reach the bottom right corner from the top-left corner
     * by only moving right or downwards.
     * 
     * Consider cell grid[0][0], there is exactly one way to go there (not moving).
     * Consider cell grid[1][1], there are two ways of going there (first go right, then down) or (first go down, then right)
     * Idea: Build up a grid of dimensions mxn and enter the number of ways to go there through the formular
     * grid[i][j] = grid[i-1][j] (moved down) + grid[i][j-1] (moved right)
     * Return grid[m-1][n-1].
     */
    public int count(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                var fromTop = i - 1 >= 0 ? grid[i-1][j] : 0;
                var fromLeft = j - 1 >= 0 ? grid[i][j-1] : 0;
                grid[i][j] += fromTop + fromLeft; // why += ? because this way we don't need to special case grid[0][0].
            }
        }
        return grid[m - 1][n - 1];
    }
}
