/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 *
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 *
 * algorithms
 * Medium (24.93%)
 * Total Accepted:    8.1K
 * Total Submissions: 31.9K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array of integers A, find the sum of min(B), where B ranges over
 * every (contiguous) subarray of A.
 * 
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2],
 * [1,2,4], [3,1,2,4]. 
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        Stack<RepNode> stack = new Stack<>();
        int ans = 0;
        int dot = 0;
        for(int i = 0; i < A.length; i++) {
            int sum = 1;
            while(!stack.isEmpty && stack.peek()._num >= A[i]) {
                RepNode polled = stack.pop();
                sum += polled._count;
                dot -= polled._count *polled._num;
            }
            stack.push(new RepNode(A[i], sum));
            dot += A[i] * 
        }
    }
    class RepNode {
        int _num;
        int _count;
        public RepNode(int num, int count) {
            this._count = count;
            this._num = num;
        }
    }
}

