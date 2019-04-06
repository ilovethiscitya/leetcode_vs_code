/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (29.17%)
 * Total Accepted:    180.2K
 * Total Submissions: 609.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ret = new int[1];
        ret[0] = Integer.MIN_VALUE;
        dfs(root, ret);
        return ret[0];
    }
    private int dfs(TreeNode node, int[] ret) {
        if(node == null) return 0;
        int self = node.val;
     
            int leftResult = dfs(node.left, ret);
        
            int rightResult = dfs(node.right, ret);
        
        int allSide = leftResult + rightResult + self;
        int result = maxInFour(self, leftResult + self, rightResult + self, allSide);
        if(result > ret[0]) {
            ret[0] = result;
        }
        return maxInThree(self, leftResult + self, rightResult + self);
    }
    private int maxInFour(int a, int b, int c, int d) {
        return Math.max(Math.max(a,b), Math.max(c,d));
    }
    private int maxInThree(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}

