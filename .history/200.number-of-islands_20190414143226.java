/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (40.04%)
 * Total Accepted:    330.6K
 * Total Submissions: 807.5K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */
class Solution {
    public int numIslands(char[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }
    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if(x - 1 >= 0 && grid[x - 1][y] == '1') {
            dfs(grid, x - 1, y);
        }
        if(x + 1 < grid.length && grid[x + 1][y] == '1') {
            dfs(grid, x + 1, y);
        }
        if(y - 1 >= 0 && grid[x][y - 1] == '1') {
            dfs(grid, x, y - 1);
        }
        if(y + 1 < grid[0].length && grid[x][y + 1] == '1') {
            dfs(grid, x, y + 1);
        }
    }
}

