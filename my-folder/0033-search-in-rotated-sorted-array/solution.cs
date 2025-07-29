public class Solution {
    public int Search(int[] nums, int target) {
        int p = FindPivot(nums);
        if (p == -1) {
            return BinarySearch(nums, 0, nums.Length - 1, target);
        }
        int left = BinarySearch(nums, 0, p - 1, target);
        int right = BinarySearch(nums, p, nums.Length - 1, target);
        if(left != -1) return left;
        return right;
    }

    public int BinarySearch(int[] nums, int start, int end, int target) {
        int l = start;
        int r = end;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public int FindPivot(int[] nums) {
        int l = 0;
        int r = nums.Length - 1;

        if (nums[l] < nums[r]) return 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if (m < nums.Length - 1 && nums[m] > nums[m + 1])
                return m + 1;
            if (m > 0 && nums[m] < nums[m - 1])
                return m;

            if (nums[m] >= nums[0])
                l = m + 1;
            else
                r = m - 1;
        }
        return 0;
    }
}
