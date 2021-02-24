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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retNode = new ListNode();
        int add = 0;
        ListNode currNode = retNode;
        while(l1 != null || l2 != null) {
            ListNode tempNode = new ListNode();
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
            }
            if (l2 != null) {
                v2 = l2.val;
            }
            int currVal = (v1 + v2 + add) % 10;
            // System.out.println(add);
            if ((v1 + v2 + add) >= 10) {
                add = (v1 + v2 + add)/10;
            } else {
                add = 0;
            }
            tempNode.val = currVal;
            currNode.next = tempNode;
            currNode = tempNode;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (add != 0) {
            ListNode tempNode = new ListNode();
            tempNode.val = add;
            currNode.next = tempNode;
        }
        return retNode.next;
    }
}
