# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        s = [root]
        currMin = float('inf')
        while s:
            arr = []
            for n in s:
                if n.left:
                    tempNode = n.left
                    while tempNode.right:
                        tempNode = tempNode.right
                    currMin = min(currMin, abs(n.val - tempNode.val))
                    arr.append(n.left)
                if n.right:
                    tempNode = n.right
                    while tempNode.left:
                        tempNode = tempNode.left
                    currMin = min(currMin, abs(n.val - tempNode.val))
                    arr.append(n.right)
            s = arr
        return currMin
