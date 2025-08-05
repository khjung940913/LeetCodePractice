class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        Arrays.fill(leftProducts, 1);
        int[] rightProducts = new int[nums.length];
        Arrays.fill(rightProducts, 1);
        int[] ans = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            leftProducts[i] = leftProducts[i-1]*nums[i-1];
        }
        for (int j = nums.length-2; j >= 0; j--) {
            rightProducts[j] = rightProducts[j+1]*nums[j+1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = leftProducts[i] * rightProducts[i];
        }

        return ans;
    }
}
