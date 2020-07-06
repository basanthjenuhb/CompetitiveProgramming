/**
 * @author bjenuhb
 */

public class P124 {


private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
}

    private int maxSum = Integer.MIN_VALUE;

    private int maxSumrecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = Math.max(maxSumrecursive(root.left), 0);
        int rightVal = Math.max(maxSumrecursive(root.right), 0);
        int currentMax = root.val + leftVal + rightVal;
        maxSum = Math.max(currentMax, maxSum);
        return Math.max(leftVal, rightVal) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        maxSumrecursive(root);
        return maxSum;
    }


}
