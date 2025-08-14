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
        ListNode cur = headA;

        int len1 = 0, len2 = 0;
        int diff;

        while(cur != null) {
            len1++;
            cur = cur.next;
        }

        cur = headB;
        while(cur != null) {
            len2++;
            cur = cur.next;
        }

        ListNode cur1 = headA, cur2 = headB;
    
        if(len1 != len2) {
            if(len1 > len2) {
                diff = len1 - len2;
                while(diff > 0) {
                    cur1 = cur1.next;
                    diff--;
                }
            }
            else {
                diff = len2 - len1;
                while(diff > 0) {
                    cur2 = cur2.next;
                    diff--;
                }
            }
        }

        while(cur1 != null && cur2 != null) {
            if(cur1 == cur2)
                return cur1;
            
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return null;
    }
}
