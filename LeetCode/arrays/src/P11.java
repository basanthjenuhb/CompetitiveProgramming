/**
 * @author bjenuhb
 */

public class P11 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new P11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

}
