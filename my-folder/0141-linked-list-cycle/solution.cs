/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public bool HasCycle(ListNode head) {
        if (head == null) return false;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n1.next != null && n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) return true;
        }
        return false;
    }
}
