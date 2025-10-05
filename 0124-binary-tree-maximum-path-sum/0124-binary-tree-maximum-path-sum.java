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
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        dfs(root, maxi);
        return maxi[0];
    }

    private int dfs(TreeNode root, int[] maxi) {
        if(root == null) return 0;

        int maxLeft = Math.max(0,dfs(root.left, maxi));
        int maxRight = Math.max(0,dfs(root.right, maxi));
        
        maxi[0] = Math.max(maxi[0], maxLeft + maxRight + root.val);
        return Math.max(maxLeft, maxRight) + root.val;
    }
}