/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode d1 = headA;
        ListNode d2 = headB;

        while(d1 != d2) {
            d1 = d1.next;
            d2 = d2.next;

            if(d1 == d2) return d1;

            if(d1 == null) d1 = headB;
            if(d2 == null) d2 = headA;
        }

        return d1;
    }
}
