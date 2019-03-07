import java.util.Map;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (41.48%)
 * Total Accepted:    82.4K
 * Total Submissions: 197.9K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Note:
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 * 
 */
class Solution {
    public int subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumToFreq = new HashMap<>();
        sumToFreq.put(0, 1);
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sumToFreq.containsKey(sum - target)) {
                res += sumToFreq.get(sum - target);
            }
            sumToFreq.put(sum, sumToFreq.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

