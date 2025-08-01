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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (list1 != null) {
            pq.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            pq.add(list2.val);
            list2 = list2.next;
        }
        ListNode h = new ListNode(-1);
        ListNode temp = h;
        while (!pq.isEmpty()) {
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }
        return h.next;
    }
}
