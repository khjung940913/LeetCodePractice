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
        // ListNode temp = head;
        // HashMap<Integer, ListNode> indexMap = new HashMap<Integer, ListNode>();
        // int s = 0;
        // while (temp != null) {
        //     indexMap.put(s++, temp);
        //     temp = temp.next;
        // }
        // ListNode prevNode = indexMap.get(s-n-1);
        // ListNode nextNode = indexMap.get(s-n+1);
        // if (prevNode != null) {
        //     prevNode.next = nextNode;
        // } else {
        //     return nextNode;
        // }
        // return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leader = dummy;
        ListNode follower = dummy;
        while (n > 0) {
            leader = leader.next;
            if (leader == null) return head;
            n--;
        }

        while (leader.next != null) {
            leader = leader.next;
            follower = follower.next;
        }

        follower.next = follower.next.next;
        return dummy.next;
    }
}
