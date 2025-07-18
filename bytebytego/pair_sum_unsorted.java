import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class pair_sum_unsorted {
        public ArrayList<Integer> pair_sum_unsorted(ArrayList<Integer> nums, int target) {
        // Write your code here
        HashMap<Integer, Integer> indMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++) {
            indMap.put(nums.get(i), i);
        }

        for (int i = 0; i < nums.size(); i++) {
            int t = target - nums.get(i);

            if (indMap.containsKey(t) && indMap.get(t) != i) {
                return new ArrayList<Integer>(Arrays.asList(i, indMap.get(t)));
            }
        }
        return new ArrayList<Integer>();
    }
}
