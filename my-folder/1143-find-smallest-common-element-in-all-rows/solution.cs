public class Solution {

    public int SmallestCommonElement(int[][] mat) {
        List<int> numbs = new List<int>();
        foreach(int[] a in mat) {
            foreach(int b in a) {
                numbs.Add(b);
            }
        }
        numbs.Sort();
        int n = mat.Length;
        int prev = numbs[0];
        int j = 1;
        for(int i = 1; i < numbs.Count(); i++) {
            int curr = numbs[i];
            if (prev == curr) {
                j++;
                if (j == n) return curr;
            } else {
                j = 1;
            }
            prev = curr;
        }
        return -1;
    }
}
