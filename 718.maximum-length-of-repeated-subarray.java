/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 *
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * algorithms
 * Medium (44.59%)
 * Total Accepted:    29.9K
 * Total Submissions: 66.1K
 * Testcase Example:  '[1,2,3,2,1]\n[3,2,1,4,7]'
 *
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation: 
 * The repeated subarray with maximum length is [3, 2, 1].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 
 * 
 * 
 * 
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        // int lenA = A.length;
        // int lenB = B.length;
        // int k = 0;
        // int ans = 0;
        // for(int i = 0; i < A.length; i++) {
        //     for(int j = 0; j < B.length; j++) {
        //         while(i + k < lenA && j + k < lenB && A[i + k] == B[j + k]) {
        //             k++;
        //         }
        //         ans = Math.max(ans, k);
        //         k = 0;
        //     }
        // }
        // return ans;
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for(int i = A.length - 1; i >= 0; i--) {
            for(int j = B.length - 1; j >= 0; j--) {
                if(A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if(ans < memo[i][j]) {
                        ans = memo[i][j];
                    }
                }
            }
        }
        return ans;
    }
}

