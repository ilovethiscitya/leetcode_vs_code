/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.37%)
 * Total Accepted:    379.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    // Primitive idea
    // allocate a new int[] array lenght = nums1.length + nums.length
    // put it into the new array, find the mid one
    // time complexity o(n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int mid = 0;
        if(len % 2 == 0) {
            int midLeft = len / 2 - 1;
            int midRight = len / 2;
            int i = 0;
            int j = 0;
            // [1, 2]
            // [3, 4]
            // [1, 4, 5, 6]
            // [2, 3]
            // [1, 2 ,4]
            // [3]
            // [1, 10, 100]
            // [1000]


            // while(i < nums1.length || j < nums2.length) {
            //     if(i < nums1.length && nums1[i] <= nums2[j]) {
            //         i++;
            //         midLeft--;
            //     }
                
            //     if(j < nums2.length && nums2[i] >= nums2[j]) {
            //          j++;
            //         midLeft --;
            //     }
                
            // }

            
        } else {
            mid = len / 2;
        }
    }
}
