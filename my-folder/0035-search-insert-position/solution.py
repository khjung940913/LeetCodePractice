class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        i, j = 0, len(nums)
        while i < j:
            mid = (i + j) // 2
            left = nums[mid-1] if mid-1 >= 0 else float('-inf')
            right = nums[mid+1] if mid+1 < len(nums) else float('inf')
            if left < target < right:
                if nums[mid] < target:
                    return mid + 1
                else:
                    return mid
            elif target > nums[mid]:
                i=mid+1
            elif target == nums[mid]:
                return mid
            else:
                j=mid-1
        return i
