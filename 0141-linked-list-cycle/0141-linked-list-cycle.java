/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> visited = new HashSet<>();
        while(curr != null) {
            if(visited.contains(curr)) {
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        }

        return false;
    }
}