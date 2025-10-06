/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        boolean isLeftToRight = true;
        que.offer(root);

        while(!que.isEmpty()) {
            int n = que.size();
            List<Integer> row = new ArrayList<>(n);
            for(int i=0; i<n; i++) {
                TreeNode curr = que.poll();
                if(isLeftToRight) {
                    row.add(curr.val);
                }
                else {
                    row.add(0,curr.val);
                }
                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
            }
            result.add(row);
            isLeftToRight = !isLeftToRight;
        }

        return result;
    }
}