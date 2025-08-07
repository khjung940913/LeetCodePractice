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
    public boolean isBalanced(TreeNode root) {
        return getHeightBalanced(root) != -1;
    }

    public int getHeightBalanced(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = getHeightBalanced(root.left);
        int rightHeight = getHeightBalanced(root.right);

        if (leftHeight == -1) return -1;
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
