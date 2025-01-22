class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        c = 0
        for w in words:
            if w.startswith(pref):
                c+=1
        return c
