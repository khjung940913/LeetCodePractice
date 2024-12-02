# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        
        def div(nums):
            if not nums:
                return None
            midIndex = len(nums)//2
            midVal = nums[midIndex]
            return TreeNode(
                midVal, 
                div(nums[:midIndex]) if midIndex-1 >= 0 else None, 
                div(nums[midIndex+1:]) if midIndex+1 < len(nums) else None
            )
        
        return div(nums)
