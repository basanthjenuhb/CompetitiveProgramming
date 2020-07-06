/**
 * @author bjenuhb
 */


class TreeNode {
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

public class P2 {

    private boolean isSame(TreeNode large, TreeNode small) {
        if (large == null && small == null) {
            return true;
        }

        if (large == null || small == null) {
            return false;
        }

        if (large.val == small.val) {
            return isSame(large.left, small.left) && isSame(large.right, small.right);
        }

        return false;
    }

    public boolean isSubtree(TreeNode large, TreeNode small) {
        if (large == null && small == null) {
            return true;
        }

        if (large == null || small == null) {
            return false;
        }

        if (isSame(large, small)) {
            return true;
        }
        return isSubtree(large.left, small) || isSubtree(large.right, small);
    }

}
