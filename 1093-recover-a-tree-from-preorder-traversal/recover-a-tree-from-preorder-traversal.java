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
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.isEmpty()) {
            return null;
        }

        int[] index = {0};
        return buildTree(traversal, 0, index);
    }

    private TreeNode buildTree(String traversal, int depth, int[] index) {
        int currentDepth = 0;
        while (index[0] + currentDepth < traversal.length() && traversal.charAt(index[0] + currentDepth) == '-') {
            currentDepth++;
        }

        if (currentDepth != depth) {
            return null;
        }

        int valueStart = index[0] + currentDepth;
        int valueEnd = valueStart;
        while (valueEnd < traversal.length() && Character.isDigit(traversal.charAt(valueEnd))) {
            valueEnd++;
        }

        int value = Integer.parseInt(traversal.substring(valueStart, valueEnd));
        TreeNode node = new TreeNode(value);
        index[0] = valueEnd;

        node.left = buildTree(traversal, depth + 1, index);
        if (node.left != null) {
            node.right = buildTree(traversal, depth + 1, index);
        }

        return node;
    }
}
class Node{
    int value;
    int dashFreq;
    int index;

    public Node(int value, int dashFreq, int index){
        this.value = value;
        this.dashFreq = dashFreq;
        this.index = index;
    }
}