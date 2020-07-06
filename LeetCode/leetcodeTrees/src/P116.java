import java.util.ArrayList;
import java.util.List;

/**
 * @author bjenuhb
 */

public class P116 {

private class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        List<Node> currentRow = new ArrayList<>();
        currentRow.add(root);

        while (!currentRow.isEmpty()) {
            List<Node> nextRow = new ArrayList<>();
            for (int i = 0; i < currentRow.size(); i++) {
                if (i != currentRow.size() - 1) {
                    currentRow.get(i).next = currentRow.get(i + 1);;
                }
                if (currentRow.get(i).left != null) {
                    nextRow.add(currentRow.get(i).left);
                }
                if (currentRow.get(i).right != null) {
                    nextRow.add(currentRow.get(i).right);
                }
            }
            currentRow = nextRow;
        }
        return root;
    }

}
