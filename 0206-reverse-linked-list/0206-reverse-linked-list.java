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

        if(head == null) {
            return null;
        }

        ListNode curr, prev, front;
        curr = head;
        prev = null;
        front = curr.next;

        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = front;
            
            if(front != null) {
                front = front.next;   //front.next
            }
        }

        return prev;
    }
}