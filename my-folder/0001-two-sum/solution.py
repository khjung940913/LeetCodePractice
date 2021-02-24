class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        Constraints:
        2 <= nums.length <= 103
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.
        """
        nums = sorted([(idx, num) for (idx, num) in enumerate(nums)], key=lambda x: x[1])
        for e_i, (idx, num) in enumerate(nums):
            for (t_idx, t_num) in nums[e_i + 1:]:
                if target - num == t_num:
                    return [idx, t_idx]
