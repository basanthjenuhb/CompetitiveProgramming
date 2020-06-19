import java.util.Arrays;

/**
 * @author bjenuhb
 */

public class P1143 {

    int[][] dp;

    public int lcsR(char[] text1, int n1, char[] text2, int n2) {
        if (Math.min(n1, n2) < 0) {
            return 0;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        if (text1[n1] == text2[n2]) {
            return dp[n1][n2] = 1 + lcsR(text1, n1 - 1, text2, n2 - 1);
        }
        return dp[n1][n2] = Math.max(
            lcsR(text1, n1, text2, n2 - 1),
            lcsR(text1, n1 - 1, text2, n2)
        );
    }

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] array: dp) {
            Arrays.fill(array, -1);
        }
        return lcsR(text1.toCharArray(), text1.length() - 1, text2.toCharArray(), text2.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new P1143().longestCommonSubsequence("abcde", "ace"));
    }

}
