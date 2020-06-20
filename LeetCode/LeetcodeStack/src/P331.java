/**
 * @author bjenuhb
 */

public class P331 {

    public int count = -1;

    public boolean recursive(String[] nodes) {
        if (count >= nodes.length) {
            return false;
        }
        if (count >= 0)
            System.out.println("Count = " + count + " node = " + nodes[count]);
        if (count >= 0 && nodes[count].equalsIgnoreCase("#")) {
            count++;
            return true;
        }
        count++;
        recursive(nodes);
        count++;
        recursive(nodes);
        return false;
    }

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        recursive(nodes);
        return false;
    }

    public static void main(String[] args) {
        new P331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

}
