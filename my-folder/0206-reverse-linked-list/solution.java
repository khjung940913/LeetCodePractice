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
    public ListNode reverseList(ListNode head) {
        // if (head == null) return null;
        // ListNode prev = null;
        // ListNode curr = head;
        // while (curr != null) {
        //     var tempCurrNext = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = tempCurrNext;
        // }
        // return prev;
        return reverseListRecursive(head);
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode restHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return restHead;
    }
}
