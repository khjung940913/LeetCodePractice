class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        ans = 0
        curr = 0
        prev = None
        increasing = None
        for n in nums:
            if prev is None:
                curr += 1
            elif prev > n:
                if increasing is None or not increasing:
                    curr += 1
                else:
                    ans = max(ans, curr)
                    curr = 2
                increasing = False
            elif prev < n:
                if increasing is None or increasing:
                    curr += 1
                else:
                    ans = max(ans, curr)
                    curr = 2
                increasing = True
            else:
                increasing = None
                ans = max(ans, curr)
                curr = 1
            prev = n

        if curr != 0:
            ans = max(ans, curr)
        return ans
