import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        while (i < n) {
            int[] merged = intervals[i];
            while (i + 1 < n && shouldMergeTwo(merged, intervals[i+1])) {
                merged = mergeTwo(merged, intervals[i+1]);
                i++;
            }
            i++;
            res.add(merged);
        }
        return res.toArray(new int[res.size()][]);
    }

    public boolean shouldMergeTwo(int[] int1, int[] int2) {
        return int2[0] <= int1[1];
    }

    public int[] mergeTwo(int[] int1, int[] int2) {
        return new int[]{Math.min(int1[0], int2[0]), Math.max(int1[1], int2[1])};
    }
}
