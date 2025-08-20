class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new HashSet<Integer>(), new ArrayList<Integer>(), ans);
        return ans;
    }

    public void backtrack(int[] nums, HashSet<Integer> used, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!used.contains(num)) {
                curr.add(num);
                used.add(num);
                backtrack(nums, used, curr, ans);
                curr.remove(curr.size() - 1);
                used.remove(num);
            }
        }
    }
}
