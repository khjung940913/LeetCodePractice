import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class triplet_sum {
    public static ArrayList<ArrayList<Integer>> triplet_sum(ArrayList<Integer> nums) {
        // Write your code here
        Collections.sort(nums);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        // System.out.println(nums);

        Integer iPrev = null;
        for(int i = 0; i < nums.size(); i++) {
            int iNumb = nums.get(i);
            if (iPrev != null && iPrev.equals(iNumb)) {
                continue;
            } else if (iNumb > 0) {
                break;
            } else {
                int j = i + 1;
                int k = nums.size() - 1;
                int target = -iNumb;
                Integer prevJ = null;
                while (j < k) {
                    int jNumb = nums.get(j);
                    int kNumb = nums.get(k);
                    // System.out.println(target + ":" + iNumb + "," + jNumb + "," + kNumb);
                    if (prevJ != null && prevJ.equals(jNumb)) {
                        j++;
                    } else if (jNumb + kNumb == target) {
                        // System.out.println("hi");
                        ans.add(new ArrayList<Integer>(Arrays.asList(iNumb, jNumb, kNumb)));
                        prevJ = jNumb;
                    } else if (jNumb + kNumb > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            iPrev = iNumb;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(triplet_sum(new ArrayList<>(Arrays.asList(0, -1, 2, -3, 1))));
    }
}
