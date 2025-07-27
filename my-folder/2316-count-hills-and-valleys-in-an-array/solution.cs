public class Solution {
    public int CountHillValley(int[] nums) {
        int ans = 0;
        int i = 1;
        if (nums == null || nums.Length == 1) return 0;
        while (i < nums.Length - 1) {
            int prev = nums[i-1];
            while(nums[i] == nums[i+1] && i < nums.Length - 2) {
                i++;
            }
            int curr = nums[i];
            int after = nums[i+1];
            if ((prev < curr && after < curr) || (prev > curr && after > curr)) {
                ans++;
            }
            i++;
        }
        return ans;
    }
}
