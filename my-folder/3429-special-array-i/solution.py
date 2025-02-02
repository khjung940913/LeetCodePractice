class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        if len(nums) == 1: return True
        if len(nums) == 2: return (nums[0] % 2 == 0 and nums[1] % 2 == 1) or (nums[0] % 2 == 1 and nums[1] % 2 == 0)
        for i in range(1, len(nums)-1):
            if nums[i] % 2 == 0:
                if nums[i-1]%2 == 0 or nums[i+1]%2 == 0:
                    return False
            else:
                if nums[i-1]%2 == 1 or nums[i+1]%2 == 1:
                    return False
        return True
