
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private Set<Integer> used = new HashSet<>();

    public boolean backtrack(int i, int n, int[] res) {
        if (i == res.length) {
            return true;
        }

        for (int num = n; num >= 1; num--) {
            if (used.contains(num)) {
                continue;
            }

            if (num > 1 && (i + num >= res.length || res[i+num] != 0)) {
                continue;
            }

            used.add(num);
            res[i] = num;
            if (num > 1) {
                res[i + num] = num;
            }

            int next = 0;
            while (next < res.length && res[next] > 0) {
                next++;
            }

            if (backtrack(next, n, res)) {
                return true;
            }

            used.remove(num);
            res[i] = 0;
            if (num > 1) {
                res[i + num] = 0;
            }
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2*n-1];
        Arrays.fill(res, 0);
        this.backtrack(0, n, res);
        return res;
    }
}
