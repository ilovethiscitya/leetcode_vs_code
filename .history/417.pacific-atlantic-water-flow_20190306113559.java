import java.util.List;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (36.52%)
 * Total Accepted:    39.4K
 * Total Submissions: 107.3K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a
 * cell to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * Note:
 * 
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * 
 * 
 * Example:
 * 
 * Given the following 5x5 matrix:
 * 
 * ⁠ Pacific ~   ~   ~   ~   ~ 
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * Atlantic
 * 
 * Return:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 * 
 * 
 */
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] toPacific = new boolean[m][n];
        boolean[][] toAtlantic = new boolean[n][m];
        for(int col = 0; col < n; col++) {
            dfs(matrix, 0, col, toPacific);
        }
        for(int row = 0; row < m; row++) {
            dfs(matrix, row, 0, toPacific);
        }
        for(int col = 0; col < n; col++) {
            dfs(matrix, m - 1, col, toAtlantic);
        }
        for(int row = 0; row < n; row++) {
            dfs(matrix, row, n - 1, toAtlantic);
        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(toAtlantic[i][j] && toPacific[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return result;
    }
    private void dfs(int[][] matrix, int row, int col, boolean[][] result) {
        if(result[row][col] != null) return;
        result[row][col] = true;
        if(row - 1 >= 0 && matrix[row][col] >= matrix[row - 1][col]) {
            dfs(matrix, row - 1, col, result);
        }
        if(row + 1 < matrix.length && matrix[row][col] >= matrix[row + 1][col]) {
            dfs(matrix, row + 1, col, result);
        }
        if(col - 1 >= 0 && matrix[row][col] >= matrix[row][col - 1]) {
            dfs(matrix, row, col - 1, result);
        }
        if(col + 1 >= 0 && matrix[row][col] >= matrix[row - 1][col]) {
            dfs(matrix, row - 1, col, result);
        }
    }
}

