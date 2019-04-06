/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (39.33%)
 * Total Accepted:    157K
 * Total Submissions: 391.1K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, 0, path, res);
        return res;
    }
    private dfs(String s, int start, List<String> path, List<List<String>> res) {
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
        }
        for(int i = start; i < s.length(); i++) {
            if(isPal(s, start, i)) {
                dfs(s, i + 1, path, res)
            }
        }
    }
}

