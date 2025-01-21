class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        r_n, c_n = len(mat), len(mat[0])
        r_c, c_c = [0] * r_n, [0] * c_n

        sorted_mat = sorted([(x, r, c) for r, xs in enumerate(mat) for c, x in enumerate(xs)])

        def findNumb(n):
            l, r = 0, len(sorted_mat) -1
            while l <= r:
                m = (l + r) // 2
                if sorted_mat[m][0] < n:
                    l = m + 1
                else:
                    r = m - 1
            return sorted_mat[l]

        for ind, numb in enumerate(arr):
            _,r,c = findNumb(numb)
            r_c[r]+=1
            c_c[c]+=1
            if r_c[r] == c_n or c_c[c] == r_n:
                return ind
        return -1


