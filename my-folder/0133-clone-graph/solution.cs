/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new List<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new List<Node>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

public class Solution {

    private Dictionary<Node, Node> copyCache = new();

    public Node CloneGraph(Node node) {
        if (node == null) return null;
        if (copyCache.ContainsKey(node)) return copyCache[node];
        Node cp = new Node(node.val);
        copyCache[node] = cp;
        foreach(var n in node.neighbors) {
            cp.neighbors.Add(CloneGraph(n));
        }
        return cp;
    }
}
