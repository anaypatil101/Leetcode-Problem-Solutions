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
        if(head == null || head.next == null) {
            return null;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            nodeList.add(curr);
            curr = curr.next;
        }
        int size = nodeList.size();

        if(size == n) return head.next;
        
        curr = nodeList.get(size - n - 1);
        curr.next = curr.next.next;

        return head;
    }
}