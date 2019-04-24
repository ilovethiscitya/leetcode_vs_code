/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence/description/
 *
 * algorithms
 * Medium (46.09%)
 * Total Accepted:    84.8K
 * Total Submissions: 182.2K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * 
 * 
 * You may assume that there is only lower case English letters in both s and
 * t. t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (
 * 
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * 
 * 
 * Return true.
 * 
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * 
 * 
 * Return false.
 * 
 * 
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        // a a c
        // a a a c
        int sLen = s.length();
        int tLen = t.length();
        if(t == null || t.length() == 0 || s == null || s.length() == 0) {
            return true;
        }
        boolean[][] dp = new boolean[sLen + 1][tLen + 1];
        if(s.charAt(0) == t.charAt(0)) {
            dp[0][0] = true;
        }
        for(int i = 1; i < sLen; i++) {
            for(int j = 1; j < tLen; j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[0][0];
    }
}

