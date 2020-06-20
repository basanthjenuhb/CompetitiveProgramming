import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bjenuhb
 */

public class P456 {

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (int num: nums) {
            if (stack.size() == 0) {
                stack.push(num);
                continue;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                result.add(num);
            }
        }
        while (!stack.isEmpty()) {
            stack.pop();
            result.add(-1);
        }
        System.out.println(result);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P456().find132pattern(new int[]{13, 7, 6, 12}));
    }

}
