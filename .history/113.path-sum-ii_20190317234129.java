/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (39.22%)
 * Total Accepted:    216.7K
 * Total Submissions: 546.5K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, new ArrayList<>(), res,  sum);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> path, List<List<Integer>> res, int target) {
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(root.left != null) {
            dfs(root.left, path, res, sum - root.val);
        }
        if(root.right != null) {
            dfs(root.right, path, res, sum - root.val);
        }
        path.remove(path.size() - 1);
    }
}

