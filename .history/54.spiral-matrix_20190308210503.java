import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (29.45%)
 * Total Accepted:    211.9K
 * Total Submissions: 714.1K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length;
        int colBegin = 0;
        int colEnd = matrix[0].length;
        int m = matrix.length;
        int n = matrix[0].length;
        while(rowBegin <= rowEnd && colBegin<= colEnd) {
            for(int i = colBegin; i <= colEnd; i++) {
                ans.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int j = rowBegin; j < rowEnd; j++) {
                ans.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            for(int i = colEnd; i >= colBegin; i--) {
                ans.add(matrix[rowEnd][i]);
            
            }
            rowEnd--;
            for(int j = rowEnd; j >= rowBegin; j--) {
                ans.add(matrix[j][colBegin]);
            }
            colBegin++;
        }
        return ans;
    }
}

