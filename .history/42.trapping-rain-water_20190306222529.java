/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (41.58%)
 * Total Accepted:    259.5K
 * Total Submissions: 618.2K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */
class Solution {
    public int trap(int[] A) {
        if(A == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        int water = 0;
        for(int i = 0; i < A.length; i++) {
            if(stack.isEmpty() || A[stack.peek()] >= A[i]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    int polled = stack.pop();
                    water += stack.isEmpty() ? 0 : Math.min(prev, A[i]) - A[polled];
                }
                prev = i;
                stack.push(i);
            }
        }
        return water;
    }
}

