// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

    static class Info {
        int size;     // size of subtree
        int min;      // minimum value in subtree
        int max;      // maximum value in subtree
        boolean isBST;

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    static int largestBst(Node root) {
        return solve(root).size;
    }

    static Info solve(Node root) {
        // Base case
        if (root == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        // Check if current subtree is BST
        if (left.isBST && right.isBST &&
            root.data > left.max && root.data < right.min) {

            int size = left.size + right.size + 1;
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);

            return new Info(size, min, max, true);
        }

        // Not a BST
        return new Info(
            Math.max(left.size, right.size),
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            false
        );
    }
}