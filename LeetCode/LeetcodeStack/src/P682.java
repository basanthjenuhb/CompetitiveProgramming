import java.util.Stack;

/**
 * @author bjenuhb
 */

public class P682 {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(String operation: ops) {
            if (operation.equalsIgnoreCase("+")) {
                Integer points = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
                stack.push(points);
            } else if (operation.equalsIgnoreCase("D")) {
                stack.push(stack.peek() * 2);
            } else if (operation.equalsIgnoreCase("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }
        int sum = 0;
        while (!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new P682().calPoints(new String[]{"5","2","C","D","+"}));
    }
}
