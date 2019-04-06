import java.util.HashMap;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (40.72%)
 * Total Accepted:    197.6K
 * Total Submissions: 479.3K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int freq = 1;
            int left = 0;
            int right = 0;
            if(map.containsKey(cur)) {
                continue;
            }
            if(map.containsKey(cur - 1)) {
                left = map.get(cur - 1);
            }
            if(map.containsKey(cur + 1)) {
                right = map.get(cur + 1);
            }
            max = Math.max(max, freq + left + right);
            map.put(cur, freq + left + right);
            map.put(cur - left, freq + left + right);
            map.put(cur + right, freq + left + right);
        }
        return max;
    }
}

