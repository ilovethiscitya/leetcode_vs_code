import java.util.HashSet;
import java.util.Set;


/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (40.48%)
 * Total Accepted:    175K
 * Total Submissions: 421.3K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class Solution {
    public int numSquares(int n) {
        Set<Integer> addedToQueue = new HashSet();
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.offer(n);
        int[] candidates = getCandidates(n);
        addedToQueue.add(n);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int polled = q.remove();
                if(polled == 0) {
                    return level;
                }
                for(int candidate : candidates) {
                    int next = polled - candidate;
                    if(next > 0 && !addedToQueue.contains(next)) {
                        q.add(next);
                        addedToQueue.add(next);
                    }
                }
            }
            level++;
        }
        return 0;
    }
    private int[] getCandidates(int n) {
        int sqrt = (int)Math.sqrt(n);
        int[] a = new int[sqrt];
        for(int i = 0; i < sqrt; i++) {
            a[i] = (i + 1) * (i + 1);
        }
        return a;
    }
}

