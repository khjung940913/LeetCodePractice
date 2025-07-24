public class Solution {
    private List<int>[] graph;
    private int[] xor;
    private int[] parent;
    private int totalXor;
    private int n;

    public int MinimumScore(int[] nums, int[][] edges) {
        n = nums.Length;
        graph = new List<int>[n];
        xor = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) graph[i] = new List<int>();

        foreach (var e in edges) {
            graph[e[0]].Add(e[1]);
            graph[e[1]].Add(e[0]);
        }

        DFS(0, -1, nums);
        totalXor = xor[0];

        int result = int.MaxValue;

        // Try all pairs of edges (as nodes with parent-child relationship)
        for (int u = 1; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                int x, y, z;

                // u and v must not be in same subtree
                if (IsAncestor(u, v)) {
                    x = xor[v];
                    y = xor[u] ^ xor[v];
                    z = totalXor ^ xor[u];
                } else if (IsAncestor(v, u)) {
                    x = xor[u];
                    y = xor[v] ^ xor[u];
                    z = totalXor ^ xor[v];
                } else {
                    x = xor[u];
                    y = xor[v];
                    z = totalXor ^ xor[u] ^ xor[v];
                }

                int max = Math.Max(x, Math.Max(y, z));
                int min = Math.Min(x, Math.Min(y, z));
                result = Math.Min(result, max - min);
            }
        }

        return result;
    }

    private void DFS(int node, int par, int[] nums) {
        xor[node] = nums[node];
        parent[node] = par;

        foreach (var nei in graph[node]) {
            if (nei != par) {
                DFS(nei, node, nums);
                xor[node] ^= xor[nei];
            }
        }
    }

    private bool IsAncestor(int u, int v) {
        // Return true if u is an ancestor of v
        while (v != -1) {
            if (v == u) return true;
            v = parent[v];
        }
        return false;
    }
}

