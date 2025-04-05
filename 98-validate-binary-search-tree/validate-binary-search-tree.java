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
    public boolean isValidBST(TreeNode root) {
        return checkForBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean checkForBST(TreeNode root, long min, long max){
        if(root == null) return true;
        long currVal = root.val;
        if(currVal<= min || currVal >= max) return false;

        return checkForBST(root.left, min, root.val) && checkForBST(root.right, root.val, max);
    } 
}