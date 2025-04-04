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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        getMaxNodeDepth(root, depthMap);

        // for(TreeNode node : depthMap.keySet()){
        //     System.out.println(node.val + " : " + depthMap.get(node));
        // }

        return getAncestor(root, depthMap);
    }

    TreeNode getAncestor(TreeNode node, Map<TreeNode, Integer> depthMap){
        if(node == null) return null;

        int leftDepth = depthMap.getOrDefault(node.left, -1);
        int rightDepth = depthMap.getOrDefault(node.right, -1);

        if(leftDepth == rightDepth) return node;
        if(leftDepth == -1 || rightDepth == -1) return leftDepth < 0 ? getAncestor(node.right, depthMap) : getAncestor(node.left, depthMap);

        if(leftDepth > rightDepth) return getAncestor(node.left, depthMap);
        return getAncestor(node.right, depthMap);
    }


    int getMaxNodeDepth(TreeNode node, Map<TreeNode, Integer> depthMap){
        if(node == null) return 0;
        if(node.left == null && node.right == null){
            depthMap.put(node, 0);
            return 0;
        }

        int left = getMaxNodeDepth(node.left, depthMap);
        int right = getMaxNodeDepth(node.right, depthMap);
        int currMaxDepth = Math.max(left, right) + 1;
        depthMap.put(node, currMaxDepth);

        return currMaxDepth;
    }
}