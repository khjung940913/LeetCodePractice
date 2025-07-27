/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            var tempCurrNext = curr.next;
            if (prev != null) {
                curr.next = prev;
            } else {
                curr.next = null;
            }
            if (curr != null) prev = curr;
            curr = tempCurrNext;
        }
        return prev;
    }
}
