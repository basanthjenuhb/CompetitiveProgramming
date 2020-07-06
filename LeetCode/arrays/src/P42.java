import java.util.Stack;

/**
 * @author bjenuhb
 */

public class P42 {

    public int trap(int[] height) {
        int current = 0, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int bar: height) {
            while (!stack.isEmpty() && bar > stack.peek()) {
                Integer previousBar = stack.pop();
                Integer previousToPreviousBar = stack.peek();
//                result = result + Math.min(bar, previousToPreviousBar)
            }
        }
        return result;
    }

}
