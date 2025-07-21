/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        HashMap<Integer, ListNode> indexMap = new HashMap<Integer, ListNode>();
        int s = 0;
        while (temp != null) {
            indexMap.put(s++, temp);
            temp = temp.next;
        }
        ListNode prevNode = indexMap.get(s-n-1);
        ListNode nextNode = indexMap.get(s-n+1);
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            return nextNode;
        }
        return head;
    }
}
