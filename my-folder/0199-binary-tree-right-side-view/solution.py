# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        ans = []
        level = [root]
        while level:
            ans.append(level[-1].val)
            temp = []
            for l in level:
                if l.left:
                    temp.append(l.left)
                if l.right:
                    temp.append(l.right)
            level = temp
        return ans
