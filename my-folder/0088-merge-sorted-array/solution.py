class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        l = m + n
        i, j, c = 0, 0, 0
        while i < l and j < n:
            if nums1[i] < nums2[j] and i < m + c:
                i += 1
            else:
                k = l - 1
                while k > i:
                    nums1[k] = nums1[k - 1]
                    k-=1
                nums1[i] = nums2[j]
                i += 1
                j += 1
                c += 1
