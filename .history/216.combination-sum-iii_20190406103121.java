/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (50.24%)
 * Total Accepted:    116.7K
 * Total Submissions: 229.3K
 * Testcase Example:  '3\n7'
 *
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * 
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(1, k, 0, n, list, res);
        return res;
    }
    private void dfs(int cur, int k, int start, int target, List<Integer> list, List<List<Integer>> res) {
        
        if(start == k && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(start > k) return;
        for(int i = cur; i <= 9; i++) {
            list.add(i);
            dfs(i + 1, k, start + 1, target - i, list, res);
            list.remove(list.size() - 1);
        }
    }
}

