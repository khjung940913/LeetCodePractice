import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public int cutting_wood(ArrayList<Integer> heights, int k) {
        // Write your code here
        int l = 0;
        int r = Collections.max(heights);
        while (l < r) {
            int mid = (l + r) / 2 + 1;
            if (is_cut_atleast_k(heights, mid, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean is_cut_atleast_k(ArrayList<Integer> heights, int c, int k) {
        int a = 0;
        for (int h : heights) {
            a += Math.max((h - c), 0);
        }
        return a >= k;
    }
}
