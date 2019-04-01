/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (45.17%)
 * Total Accepted:    54.1K
 * Total Submissions: 118.3K
 * Testcase Example:  '"bbbab"'
 *
 * 
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * 
 * Example 1:
 * Input: 
 * 
 * "bbbab"
 * 
 * Output: 
 * 
 * 4
 * 
 * One possible longest palindromic subsequence is "bbbb".
 * 
 * 
 * Example 2:
 * Input:
 * 
 * "cbbd"
 * 
 * Output:
 * 
 * 2
 * 
 * One possible longest palindromic subsequence is "bb".
 * 
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        return dfs(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    private int dfs(String s, int start, int end, Integer[][] memo) {
        if(memo[start][end] != null) {
            return memo[start][end];
        }
        if(start > end) return 0;
        if(start == end) return 1;
        if(s.charAt(start) == s.charAt(end)) {
            memo[start][end] = dfs(s, start + 1, end - 1, memo) + 2;
        } else {
            memo[start][end] = Math.max(dfs(s, start, end - 1, memo), dfs(s, start + 1, end, memo)); 
        }
        return memo[start][end];
    }
}

