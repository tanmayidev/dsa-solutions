/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    private class Result {
        TreeNode node;  // The answer node
        int depth;      // The depth at this node
        
        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }
        
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        
        // Case 1: Left subtree is deeper
        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        }
        
        // Case 2: Right subtree is deeper
        if (left.depth < right.depth) {
            return new Result(right.node, right.depth + 1);
        }
        
        // Case 3: Both subtrees have equal depth
        return new Result(root, left.depth + 1);
    }
}
