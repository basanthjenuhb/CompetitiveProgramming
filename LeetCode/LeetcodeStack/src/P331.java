import java.util.Stack;

/**
 * @author bjenuhb
 */

public class P331 {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        int count = 1;
        for (String node: nodes) {
            count--;
            if (count < 0) {
                return false;
            }
            if (node.equalsIgnoreCase("#")) {
                continue;
            }
            count += 2;
        }

        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(new P331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

}
