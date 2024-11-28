class Solution:
    def isPalindrome(self, s: str) -> bool:
        astr = ""
        for c in s:
            if c.isalpha() or c.isnumeric():
                astr += str(c.lower())
        # print(astr)
        i, j = 0, len(astr) - 1
        while i < j:
            if astr[i] != astr[j]:
                return False
            i += 1
            j -= 1
        return True

