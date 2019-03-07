/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.40%)
 * Total Accepted:    486.3K
 * Total Submissions: 1.8M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int longestStart = 0;
        int longestEnd = 0;
        int n = 0;
        for(int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i;
            while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                if(end - start > longestEnd - longestStart) {
                    longestEnd = end;
                    longestStart = start;
                }
                start--;
                end++;
            }
        }
        for(int i = 1; i < s.length(); i++) {
            int start = i - 1;
            int end = i;
            while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                if(end - start > longestEnd - longestStart) {
                    longestEnd = end;
                    longestStart = start;
                }
                end++;
                start--;
            }
        }
        return s.substring(longestStart, longestEnd + 1);
    }
}

