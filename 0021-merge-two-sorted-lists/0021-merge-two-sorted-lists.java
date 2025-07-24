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

        if(list1 == null && list2 == null) return null;

        if(list1 == null) return list2;
        if(list2 == null) return list1;


        ListNode curr1 = list1, curr2 = list2;
        ListNode newHead = new ListNode();  
        ListNode curr3 = newHead;


        while(curr1 != null && curr2 != null) {
            ListNode newNode = new ListNode();
            if(curr1.val <= curr2.val) {
                newNode.val = curr1.val;
                curr1 = curr1.next;
            }
            else {
                newNode.val = curr2.val;
                curr2 = curr2.next;
            }
            curr3.next = newNode;
            curr3 = curr3.next;
        }

        while(curr1 != null) {
            ListNode newNode = new ListNode(curr1.val);
            curr3.next = newNode;
            curr1 = curr1.next;
            curr3 = curr3.next;
        }

        while(curr2 != null) {
            ListNode newNode = new ListNode(curr2.val);
            curr3.next = newNode;
            curr3 = curr3.next;
            curr2 = curr2.next;
        }

        return newHead.next;
    }
}