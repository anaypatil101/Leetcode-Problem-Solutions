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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > val && curr.left != null ) {
                curr = curr.left;

            } else if( curr.val < val && curr.right != null ) {
                curr = curr.right;
            } 
            else 
                break;
        }
        if(val > curr.val) 
            curr.right = new TreeNode(val);
        if(val < curr.val)
            curr.left = new TreeNode(val);
        
        return root;
    }
}