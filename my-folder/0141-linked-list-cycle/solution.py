# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False
        temp = head
        temp2 = head

        while temp.next is not None and temp2.next is not None and temp2.next.next is not None:
            if temp.next == temp2.next.next:
                return True
            temp = temp.next
            temp2 = temp2.next.next
        return False
