class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        c = 0
        for i in range(len(words)):
            for j in range(len(words)):
                if i < j and words[j].startswith(words[i]) and words[j].endswith(words[i]):
                    c+=1
        return c
