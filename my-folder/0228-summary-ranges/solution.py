class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        ans = []
        curr = []
        prev = None
        for num in nums:
            if not curr:
                curr.append(str(num))
            elif num - prev == 1:
                # curr.append(str(num))
                prev = num
                continue
            else:
                if prev != int(curr[-1]):
                    curr.append(str(prev))
                ans.append("->".join(curr))
                curr = [str(num)]
            prev = num
        if curr:
            if prev != int(curr[-1]):
                curr.append(str(prev))
            ans.append("->".join(curr))

        return ans
