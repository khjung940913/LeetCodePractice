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
    
    int preOrderIndex = 0;
    Dictionary<int, int> inOrderValueIndexMap = new Dictionary<int, int>();
    
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.Length;i++) inOrderValueIndexMap[inorder[i]] = i;
        return BuildTreeRecursive(0, inorder.Length - 1, preorder, inorder);
    }

    public TreeNode BuildTreeRecursive(int left, int right, int[] preorder, int[] inorder) {
        if (left > right) return null;

        int val = preorder[preOrderIndex];
        int inorderIndex = inOrderValueIndexMap[val];

        preOrderIndex += 1;
        TreeNode currRoot = new TreeNode(val, null, null);
        currRoot.left = BuildTreeRecursive(left, inorderIndex - 1, preorder, inorder);
        currRoot.right = BuildTreeRecursive(inorderIndex + 1, right, preorder, inorder);
        return currRoot;
    }
}
