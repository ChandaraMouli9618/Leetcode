class Solution {
    long maxProduct = 0;
    int MOD = 1_000_000_007;
    int totalSum = 0;

    public int maxProduct(TreeNode root) {
        // First DFS: compute total sum
        totalSum = calculateTotalSum(root);

        // Second DFS: compute subtree sums + products
        calculateMaxProduct(root);

        return (int)(maxProduct % MOD);
    }

    // DFS 1: total sum
    int calculateTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val 
             + calculateTotalSum(root.left) 
             + calculateTotalSum(root.right);
    }

    // DFS 2: subtree sum + product evaluation
    int calculateMaxProduct(TreeNode root) {
        if (root == null) return 0;

        int leftSum = calculateMaxProduct(root.left);
        int rightSum = calculateMaxProduct(root.right);

        int subTreeSum = root.val + leftSum + rightSum;

        long product = (long) subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
