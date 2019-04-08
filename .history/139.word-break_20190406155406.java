import java.util.Set;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (34.13%)
 * Total Accepted:    317.6K
 * Total Submissions: 913.6K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] results = new boolean[n];
        Set<String> set = new HashSet<>(wordDict);
        dfs(s, 0, results, set);
        return results[n - 1];
    }
    private boolean dfs(String s, int start, boolean[] results, Set<String> set) {
        if(start == s.length()) return true;
        for(int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i);
            if(set.contains(cur)) {
                if(dfs(s, i + 1, results, set)) {
                    return true;
                }
            }
        }
        return false;
    }

   
}

