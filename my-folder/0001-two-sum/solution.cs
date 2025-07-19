public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        // Write your code here
        Dictionary<int, int> indMap = new Dictionary<int, int>();
        for (int i = 0; i < nums.Count(); i++)
        {
            indMap[nums[i]] = i;
        }

        for (int i = 0; i < nums.Count(); i++)
        {
            int t = target - nums[i];

            if (indMap.ContainsKey(t) && indMap[t] != i)
            {
                return new int[]{ i, indMap[t] };
            }
        }
        return new int[0];
    }
}
