import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author bjenuhb
 */

public class P503 {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[nums.length];

        Arrays.fill(nge, -1);

        for (int i = 0; i < 2 * nums.length; i++) {

            while (!stack.isEmpty() &&
                nums[i % nums.length] > nums[stack.peek() % nums.length]) {

                nge[stack.pop() % nums.length] = nums[i % nums.length];

            }

            stack.push(i % nums.length);
        }
        return nge;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(new P503().nextGreaterElements(new int[]{1, 2, 1})));
    }
}
