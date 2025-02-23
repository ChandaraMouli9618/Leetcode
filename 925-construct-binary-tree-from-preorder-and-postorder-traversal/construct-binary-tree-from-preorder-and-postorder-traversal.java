/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) {
            return root;
        }

        int leftRootVal = preorder[preStart + 1];
        int leftRootIndexInPost = -1;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == leftRootVal) {
                leftRootIndexInPost = i;
                break;
            }
        }

        int leftSubtreeSize = leftRootIndexInPost - postStart + 1;

        root.left = construct(preorder, preStart + 1, preStart + leftSubtreeSize, postorder, postStart, leftRootIndexInPost);
        root.right = construct(preorder, preStart + leftSubtreeSize + 1, preEnd, postorder, leftRootIndexInPost + 1, postEnd - 1);

        return root;
    }
}