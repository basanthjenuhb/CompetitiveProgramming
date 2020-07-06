import java.util.Arrays;

/**
 * @author bjenuhb
 */

public class P516 {

    public int longestPalindromeSubseq(String s) {
        String text1 = s;
        String text2 = new StringBuilder().append(s).reverse().toString();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new P516().longestPalindromeSubseq("bbbab"));
    }
}
