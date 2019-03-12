/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (32.08%)
 * Total Accepted:    130K
 * Total Submissions: 401.7K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            num.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
            System.out.println(fact[i]);
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = n; i > 0; i--) {
            int idx = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(num.get(idx));
            num.remove(idx);
        }
        return sb.toString();
    }
    public String getPermutation(int n, int k) {
        List<String> num = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            num.add(i);
        }
        int[] factor = new int[n];
        factor[0] = 1;
        for(int i = 1; i < n; i++) {
            factor[i] *= i;
        }
        k = k - 1;
        

    }
}

