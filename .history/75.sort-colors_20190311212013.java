/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (41.16%)
 * Total Accepted:    295K
 * Total Submissions: 712.3K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */
class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int idx = 0;
        while(idx <= p2) {
            if(nums[idx] == 0) {
                nums[idx] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if(nums[idx] == 2) {
                nums[idx] = nums[p2];
                nums[p2] = 2;
                p2--;
                idx--;
            }
            idx++;
        }        
    }
}

