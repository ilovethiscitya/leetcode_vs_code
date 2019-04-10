/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (29.67%)
 * Total Accepted:    223.3K
 * Total Submissions: 737.4K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for(int i = 0; i < t.length(); i++) {
            tMap[t.charAt(i)]++;
        }
        int dist = t.length();
        int start = 0;
        String result = "";

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            sMap[cur]++;
            if(tMap[cur] <= sMap[cur]) {
                dist--;
            }
            if(dist == 0) {
                while(tMap[s.charAt(start)] == 0 || tMap[s.charAt(start)] < sMap[s.charAt(start)]) {
                    start++;
                    sMap[s.charAt(start)]--;
                }
                if(result.equals("") || result.length() > i - start + 1) {
                    result = s.substring(start, i + 1);
                }
                sMap[s.charAt(start)]--;
                dist++;
                start++;
            }
        }
        return result;
    }
}

