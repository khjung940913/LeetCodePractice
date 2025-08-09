/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    int maxSum = int.MinValue;

    public int MaxPathSum(TreeNode root) {
        MaxPathSumRe(root);
        return maxSum;
    }

    public int MaxPathSumRe(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.Max(0, MaxPathSumRe(root.left));
        int rightGain = Math.Max(0, MaxPathSumRe(root.right));
        int gainThrough = root.val + leftGain + rightGain;
        maxSum = Math.Max(maxSum, gainThrough);
        return root.val + Math.Max(leftGain, rightGain);
    }
}
