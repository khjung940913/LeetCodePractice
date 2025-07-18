public class LargestContainer {
        public int largest_container(ArrayList<Integer> heights) {
        // Write your code here
        int left = 0;
        int right = heights.size() - 1;
        int ans = 0;

        while (left < right) {
            int x = right - left;
            int y = Math.min(heights.get(left), heights.get(right));
            ans = Math.max(ans, x*y);
            if (heights.get(left) == heights.get(right)) {
                left++;
                right--;
            } else if (heights.get(left) < heights.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}