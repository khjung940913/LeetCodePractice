class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        wordMap = defaultdict(int)
        for c in magazine:
            wordMap[c] += 1
        for c in ransomNote:
            wordMap[c] -= 1
            if wordMap[c] < 0:
                return False
        return True
