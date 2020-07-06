/**
 * @author bjenuhb
 */

public class P718 {

    Integer[][] dp;
    int maxResult = Integer.MIN_VALUE;

    public int findLengthRecursive(int[] array1, int index1, int[] array2, int index2) {
        int result = 0;
        if (Math.min(index1, index2) < 0) {
            return 0;
        }
        if (dp[index1][index2] != null) {
            return dp[index1][index2];
        }
        if (array1[index1] == array2[index2]) {
            result = 1 + findLengthRecursive(array1, index1 - 1, array2, index2 - 1);
        }
        findLengthRecursive(array1, index1 - 1, array2, index2);
        findLengthRecursive(array1, index1, array2, index2 - 1);
        if (result > maxResult) {
            maxResult = result;
        }
        return dp[index1][index2] = result;
    }

    public int findLength(int[] A, int[] B) {
        dp = new Integer[A.length][B.length];
        findLengthRecursive(A, A.length - 1, B, B.length - 1);
        return maxResult;
    }

    public static void main(String[] args) {
        System.out.println(new P718().findLength(new int[]{0,0,0,0,0,0,1,0,0,0}, new int[]{0,0,0,0,0,0,0,1,0,0}));
    }

}
