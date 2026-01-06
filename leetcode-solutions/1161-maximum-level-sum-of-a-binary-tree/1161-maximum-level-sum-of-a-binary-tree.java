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
    private static class NodeLevel {
        public TreeNode node;
        public Integer level;

        public NodeLevel(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public int maxLevelSum(TreeNode root) {
        long maxLevelSum = Long.MIN_VALUE;
        int maxSumLevel = 1, currLevel = 1;

        Queue<NodeLevel> queue = new LinkedList<NodeLevel>();

        queue.offer(new NodeLevel(root, currLevel));

        while(!queue.isEmpty()) {
            long currLevelSum = 0;

            NodeLevel head = queue.peek(); 

            while(head != null && head.level == currLevel) { 
                NodeLevel treeNode = queue.poll();

                if (treeNode == null) {
                    continue;
                }

                if (treeNode.node != null && treeNode.node.left != null) {
                    queue.offer(new NodeLevel(treeNode.node.left, currLevel + 1)); 
                }

                if (treeNode.node != null && treeNode.node.right != null) {
                    queue.offer(new NodeLevel(treeNode.node.right, currLevel + 1));
                }

                currLevelSum += treeNode.node.val;

                head = queue.peek();
            }

            if (currLevelSum > maxLevelSum) {
                maxLevelSum = currLevelSum;
                maxSumLevel = currLevel;
            }

            currLevel++;
        }

        return maxSumLevel;
    }
}
