
/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (38.15%)
 * Total Accepted:    174.4K
 * Total Submissions: 450.1K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] res = new int[m + 1];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                res[j] = triangle.get(i).get(j) + Math.min(res[j], res[j + 1]);
            }
        }
        return res[0];
    }
}

