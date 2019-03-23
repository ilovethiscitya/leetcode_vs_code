/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (55.55%)
 * Total Accepted:    88K
 * Total Submissions: 156.7K
 * Testcase Example:  '"abc"'
 *
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * Example 1:
 * 
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int start = i;
            int end = i;
            while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                sum++;
                start--;
                end++;
            }
        }
        
    }
}

