class Solution:
    def minimumLength(self, s: str) -> int:
        countMap = defaultdict(int)
        for c in s:
            countMap[c] += 1
        
        for k, v in countMap.items():
            if v % 2 == 0:
                countMap[k] = 2
            else:
                countMap[k] = 1
        
        return sum(countMap.values())
