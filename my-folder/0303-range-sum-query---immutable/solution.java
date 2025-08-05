class NumArray {

    int[] runningSums;

    public NumArray(int[] nums) {
        runningSums = new int[nums.length];
        if (nums.length == 0) return;
        runningSums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            runningSums[i] = runningSums[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left < 1) return runningSums[right];
        return runningSums[right] - runningSums[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
