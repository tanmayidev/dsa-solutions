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
    private static long MOD = 1_000_000_007;
    
    private List<Long> subtreeSums;

    public Solution() {
        this.subtreeSums = new ArrayList<Long>();
    }

    public int maxProduct(TreeNode root) {
        hydrateSubtreeSums(root);

        return maximumProduct();
    }

    private int maximumProduct() {
        long completeSum = Long.MIN_VALUE;
        long maximumProduct = Long.MIN_VALUE;

        for (Long subtreeSum : this.subtreeSums) {
            if (subtreeSum > completeSum) {
                completeSum = subtreeSum;
            }
        }

        for (Long subtreeSum : this.subtreeSums) {
            long currProduct = (subtreeSum) * (completeSum - subtreeSum);

            if (currProduct > maximumProduct) {
                maximumProduct = currProduct;
            }
        }

        return (int)(maximumProduct % MOD);
    }

    private long hydrateSubtreeSums(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long left = hydrateSubtreeSums(root.left);
        long right = hydrateSubtreeSums(root.right);

        long sum = root.val + left + right;

        this.subtreeSums.add(sum);

        return sum;
    }
}
