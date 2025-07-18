import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public ArrayList<Integer> pair_sum_sorted(ArrayList<Integer> nums, int target) {
        // Write your code here
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            int currSum = nums.get(i) + nums.get(j);
            if (currSum == target) {
                return new ArrayList<Integer>(Arrays.asList(i, j));
            } else if (currSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new ArrayList<Integer>();
    }
}