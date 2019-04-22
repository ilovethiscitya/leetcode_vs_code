/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (31.16%)
 * Total Accepted:    97.2K
 * Total Submissions: 306.7K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length <= 3) return new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int start = len / 3;
        List<Integer> res = new ArrayList<>();
        while(start < len) {
            if(nums[start] == nums[start - len / 3]) {
                res.add(nums[start]);
            }
            start += len / 3;
        }
        return res;
    }
}

