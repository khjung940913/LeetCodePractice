class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        digitMap = {
            2: ['a','b','c'],
            3: ['d','e','f'],
            4: ['g','h','i'],
            5: ['j','k','l'],
            6: ['m','n','o'],
            7: ['p','q','r','s'],
            8: ['t','u','v'],
            9: ['w','x','y','z'],
        }
        res = []
        curr = ""
        def recurse(curr, i):
            if i >= len(digits):
                if curr:
                    res.append(curr)
                return
            d = digits[i]
            alphs = digitMap[int(d)]
            for a in alphs:
                recurse(curr + a, i + 1)
        recurse(curr, 0)
        return res

