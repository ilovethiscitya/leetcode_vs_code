/*
 * @lc app=leetcode id=915 lang=java
 *
 * [915] Partition Array into Disjoint Intervals
 *
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/
 *
 * algorithms
 * Medium (41.73%)
 * Total Accepted:    8.3K
 * Total Submissions: 19.9K
 * Testcase Example:  '[5,0,3,8,6]'
 *
 * Given an array A, partition it into two (contiguous) subarrays left and
 * right so that:
 * 
 * 
 * Every element in left is less than or equal to every element in right.
 * left and right are non-empty.
 * left has the smallest possible size.
 * 
 * 
 * Return the length of left after such a partitioning.  It is guaranteed that
 * such a partitioning exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [5,0,3,8,6]
 * Output: 3
 * Explanation: left = [5,0,3], right = [8,6]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,0,6,12]
 * Output: 4
 * Explanation: left = [1,1,1,0], right = [6,12]
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * It is guaranteed there is at least one way to partition A as
 * described.
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] maxleft = new int[n];
        int[] minright = new int[n];

        int m = A[0];
        for(int i = 0; i < n; i++) {
            m = Math.max(m, A[i]);
            maxleft[i] = m;
        }
        m = A[n - 1];
        for(int i = n - 1; i >= 0; i--) {
            m = Math.min(m, A[i]);
            minright[i] = m;
        }
        for(int i = 1; i < n; i++) {
            if(maxleft[i - 1] <= minright[i]) {
                return i;
            }
        }
        throw null;
    }
}
