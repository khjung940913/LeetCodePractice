class Solution:
    def check(self, nums: List[int]) -> bool:
       B = sorted(nums)
       As = [[B[(i+x) % len(B)] for i in range(len(B))] for x in range(len(B))]
       for A in As:
        if nums == A:
            return True
       return False
