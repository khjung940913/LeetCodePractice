class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        ans = float('inf')
        curr = 0
        i, j = 0, 0
        while j < len(nums):
            curr += nums[j]
            if curr >= target:
                # print (j, i)
                ans = min(ans, j - i + 1)
                curr -= nums[i]
                i += 1
                curr -= nums[j]
            else:
                j += 1

        if ans == float('inf'):
            return 0
        return ans

