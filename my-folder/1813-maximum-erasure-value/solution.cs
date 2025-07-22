public class Solution {
    public int MaximumUniqueSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.Count();
        int currSum = 0;
        int currMax = 0;
        HashSet<int> used = new HashSet<int>();
        // increase r until it has unique
        while (r < n) {
            int currNum = nums[r];
            while (used.Contains(currNum)) {
                used.Remove(nums[l]);
                currSum -= nums[l];
                l++;
            }
            used.Add(currNum);
            currSum += currNum;
            currMax = Math.Max(currMax, currSum);
            r++;
        }
        return currMax;
        // if found something not unique, then increase l until it only contains unique
    }
}
