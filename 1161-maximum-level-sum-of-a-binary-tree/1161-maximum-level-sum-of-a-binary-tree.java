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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int[] maxValue = new int[2];
        maxValue[0] = Integer.MIN_VALUE;
        int level = 1;
        while(!que.isEmpty()) {
            int nodes = que.size();
            int sum = 0;    //sum of the current level
            for(int i=0; i<nodes; i++) {
                TreeNode curr = que.poll();
                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
                sum += curr.val;
            }
            if(sum > maxValue[0]) {
                maxValue[0] = sum;
                maxValue[1] = level;
            } 
            level++;
        }
        return maxValue[1];
    }
}