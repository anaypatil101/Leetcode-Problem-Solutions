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
    public int maxProduct(TreeNode root) {
        //first calculate total sum of all nodes
        long totalSum = calculateSum(root);
        long[] maxProduct = new long[1];
        calculateMaxProduct(root, totalSum, maxProduct);
        return (int) (maxProduct[0] % 1000000007);
    }

    private long calculateMaxProduct(TreeNode root, long totalSum, long[] maxProd) {
        if(root == null) return 0;
        long sum1 = calculateMaxProduct(root.left, totalSum, maxProd) + calculateMaxProduct(root.right, totalSum, maxProd) + root.val;
        long sum2 = totalSum - sum1;
        maxProd[0] = Math.max(maxProd[0], sum1 * sum2);
        return sum1;
    }

    private long calculateSum(TreeNode root) {
        if(root == null) return 0;

        long leftSum = calculateSum(root.left);
        long rightSum = calculateSum(root.right);
        return root.val + leftSum + rightSum;
    }
}