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
        int level = 1;
        que.offer(root);

        while(!que.isEmpty()) {
            int n = que.size();
            List<Integer> row = new ArrayList<>();
            for(int i=0; i<n; i++) {
                TreeNode curr = que.poll();
                
                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);

                row.add(curr.val);
            }
            if(level % 2 == 0) Collections.reverse(row);
            result.add(row);
            level++;
        }

        return result;
    }
}