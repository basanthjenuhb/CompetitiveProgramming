import javax.swing.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bjenuhb
 */

public class P102 {

    private class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        List<TreeNode> currentRow = new ArrayList<>();
        currentRow.add(root);

        int depth = 0;
        while (!currentRow.isEmpty()) {
            List<Integer> rowValues = new ArrayList<>();
            list.add(rowValues);
            List<TreeNode> nextRow = new ArrayList<>();
            for (int i = 0; i < currentRow.size(); i++) {
                list.get(depth).add(currentRow.get(i).val);
                if (currentRow.get(i).left != null) {
                    nextRow.add(currentRow.get(i).left);
                }
                if (currentRow.get(i).right != null) {
                    nextRow.add(currentRow.get(i).right);
                }
            }
            currentRow = nextRow;
            depth++;
        }
        return list;

    }

}
