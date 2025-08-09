/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    TreeNode LCS;

    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (IsLCS(root, p, q)) return LCS;
        return null;
    }

    public bool IsLCS(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int isCurrLCS = Convert.ToInt32(root == p || root == q);
        int isLeftLCS = Convert.ToInt32(IsLCS(root.left, p, q));
        int isRightLCS = Convert.ToInt32(IsLCS(root.right, p, q));
        if (isCurrLCS + isLeftLCS + isRightLCS == 2) {
            this.LCS = root;
        }
        return isCurrLCS == 1 || isLeftLCS == 1 || isRightLCS == 1;
    }
}
