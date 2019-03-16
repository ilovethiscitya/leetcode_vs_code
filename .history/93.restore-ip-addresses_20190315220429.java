/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (30.56%)
 * Total Accepted:    131.7K
 * Total Submissions: 427.2K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        restoreIp(s, results, 0, "", 0);
        return results;
    }
    private void restoreIp(String s, List<String> results, int idx, String restored, int count) {
        if(count > 4) return;
        if(count == 4 && idx == s.length()) {
            results.add(restored);
        }
        for(int i = 1; i < 4; i++) {
            if(idx + i > s.length()) return;
            String cur = s.substring(idx, idx + i);
            if(cur.startsWith("0") && s.length() > 1) continue;
            if(i == 3 && Integer.valueOf(cur) >= 256) continue;
            restoreIp(s, results, idx + i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }
}

