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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        List<Integer> input = new ArrayList<>();

        while(curr != null) {
            input.add(curr.val);
            curr = curr.next;
        }

        int left = 0, right = input.size() - 1;
        curr = head;
        while(left < right) {
            curr.val = input.get(left);
            curr.next.val = input.get(right);
            left++;
            right--;
            curr = curr.next.next;

            if(left == right) {
                curr.val = input.get(left);
            }  
        }
        
    }
}