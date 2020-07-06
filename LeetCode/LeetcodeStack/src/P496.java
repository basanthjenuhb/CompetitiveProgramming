import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author bjenuhb
 */

public class P496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int nextValue : nums2) {
            while (!stack.isEmpty() && nextValue > stack.peek()) {
                Integer element = stack.pop();
                map.put(element, nextValue);
            }
            stack.push(nextValue);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
