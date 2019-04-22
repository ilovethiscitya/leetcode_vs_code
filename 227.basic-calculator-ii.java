/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (32.48%)
 * Total Accepted:    103.9K
 * Total Submissions: 314.3K
 * Testcase Example:  '"3+2*2"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces  . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * 
 * 
 * Input: "3+2*2"
 * Output: 7
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 3/2 "
 * Output: 1
 * 
 * Example 3:
 * 
 * 
 * Input: " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */
class Solution {
    public int calculate(String s) {
        int res = 0;
        char sign = '+';
        for (int i = 0, num = 0, pre = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1) {
                if (sign == '+') {
                    pre = num;
                } else if (sign == '-') {
                    pre = -num;
                } else if (sign == '*') {
                    res -= pre;
                    pre *= num;
                } else {
                    res -= pre;
                    pre /= num;
                }
                sign = c;
                num = 0;
                res += pre;
            }
        }
        
        return res;
    }
}

