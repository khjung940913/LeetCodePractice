public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.Length - 1;
        int[] ans = new int [2] {-1, -1};
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int start = mid;
                int end = mid;
                while ((start >= 0 && nums[start] == target) || (end <= nums.Length - 1 && nums[end] == target)) {
                    if (start >= 0 && nums[start] == target) {
                        start--;
                    }
                    if (end <= nums.Length - 1 && nums[end] == target) {
                        end++;
                    }
                }
                return new int[2] {start + 1, end - 1};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
