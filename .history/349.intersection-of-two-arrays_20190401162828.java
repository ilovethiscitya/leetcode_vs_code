import java.util.ArrayList;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (52.57%)
 * Total Accepted:    205.5K
 * Total Submissions: 383.4K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }
        
        for(int num : nums2) {
            if(set.contains(num) && !res.contains(num)) {
                res.add(num);
            }
        }
        int size = res.size();
        int[] ret = new int[size];
        int idx = 0;
        for(int num : res) {
            ret[idx++] = num;
        }
        return ret;
    }
}

