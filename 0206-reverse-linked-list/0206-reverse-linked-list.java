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

        List<Integer> nodes = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {   
            nodes.add(curr.val);
            curr = curr.next;
        }

        ListNode newHead = new ListNode(nodes.get(nodes.size() - 1));
        curr = newHead;
        for(int i=nodes.size() - 2; i>=0; i--) {
            ListNode newNode = new ListNode();
            newNode.val = nodes.get(i);
            curr.next = newNode;
            curr = curr.next;
        }

        return newHead;
    }
}