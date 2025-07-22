/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<ListNode>();
        while (headB != null) {
            visited.Add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            if (visited.Contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}
