/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (30.21%)
 * Total Accepted:    253.2K
 * Total Submissions: 832.7K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    if(dfs(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        if(visited[i][j]) return false;
        if(word.charAt(idx) != board[i][j]) return false;
        visited[i][j] = true;
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        if(i - 1 >= 0) {
            left = dfs(board, i - 1, j , word, idx + 1, visited);
        }
        if(i + 1 < m) {
            right = dfs(board, i + 1, j , word, idx + 1, visited);
        }
        if(j - 1 >= 0) {
            up = dfs(board, i, j - 1, word, idx + 1, visited);
        }
        if(j + 1 < n) {
            down = dfs(board, i, j + 1, word, idx + 1, visited);
        }
        if(left || right || up || down) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}

