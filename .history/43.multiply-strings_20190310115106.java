/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (29.83%)
 * Total Accepted:    185K
 * Total Submissions: 616.9K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
//     public String multiply(String num1, String num2) {
//         int m = num1.length();
//         int n = num2.length();
//         int[] results = new int[m + n];
//         for(int i = m - 1; i >= 0; i--) {
//             for(int j = n - 1; j >= 0; j--) {
//                 int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//                 int p1 = i + j;
//                 int p2 = i + j + 1;
//                 int s = results[p2] + mul;
//                 results[p1] += s / 10;
//                 results[p2] = s % 10;
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         for(int p : results) {
//             if(!(sb.length() == 0 && p == 0)) {
//                 sb.append(p);
//             }
//         }
//         return sb.length() == 0 ? "0" : sb.toString();
//     }
//     99
//     99

//     81
//    81
//    891
//   81
//  81  
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[p2];
                result[p2] = sum % 10;
                result[p1] = sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : result) {
            if(!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

