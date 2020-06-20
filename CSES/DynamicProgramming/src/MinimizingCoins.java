import java.util.Arrays;
import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class MinimizingCoins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCoins = scanner.nextInt(), sum = scanner.nextInt();
        int[] coins = new int[totalCoins + 1];
        for (int i = 1; i <= totalCoins; i++) {
            coins[i] = scanner.nextInt();
        }
    }

}
