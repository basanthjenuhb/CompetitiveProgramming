/**
 * @author bjenuhb
 */

public class P26 {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i = i + 1;
            }
            nums[j++] = nums[i++];
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(new P26().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

}
