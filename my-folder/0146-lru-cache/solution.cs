
public class LRUCache {

    private class ListNode {
        public int key;
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int key, int val, ListNode prev, ListNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    ListNode head;
    ListNode tail;
    Dictionary<int, ListNode> nodes = new Dictionary<int, ListNode>();
    int capacity;

    public LRUCache(int capacity) {
        this.head = new ListNode(-1, -1, null, null);
        this.tail = new ListNode(-1, -1, null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
    }
    
    public int Get(int key) {
        if (!this.nodes.ContainsKey(key)) return -1;
        var n = this.nodes[key];
        this.Remove(key);
        this.Put(key, n.val);
        return n.val;
    }

    // remove node with key
    public void Remove(int key) {
        if (!this.nodes.ContainsKey(key)) return;
        ListNode n = nodes[key];
        n.prev.next = n.next;
        n.next.prev = n.prev;
        this.nodes.Remove(key);
    }
    
    public void Put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }

        if (this.Get(key) != -1) {
            this.Remove(key);
        }

        if (this.nodes.Count() >= capacity) {
            var temp2 = this.head.next.next;
            this.nodes.Remove(this.head.next.key);
            this.head.next = this.head.next.next;
            temp2.prev = this.head;
        }

        ListNode insertNode = new ListNode(key, value, null, null);
        ListNode temp3 = this.tail.prev;
        this.tail.prev.next = insertNode;
        this.tail.prev = insertNode;
        insertNode.next = this.tail;
        insertNode.prev = temp3;
        this.nodes[key] = insertNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.Get(key);
 * obj.Put(key,value);
 */
