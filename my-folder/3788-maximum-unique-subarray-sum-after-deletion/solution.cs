public class Solution {
    public int MaxSum(int[] nums) {
        HashSet<int> used = new HashSet<int>();
        foreach(int n in nums) {
            if(n > 0) used.Add(n);
        }
        if (used.Count == 0) return nums.Max();
        return used.Sum();
    }
}
