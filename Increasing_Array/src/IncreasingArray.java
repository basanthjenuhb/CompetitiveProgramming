import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        long[] numbers = new long[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextLong();
        }
        long count = 0;
        for (int i = 1; i < size; i++) {
            count += Math.max(0, numbers[i - 1] - numbers[i]);
            numbers[i] = Math.max(numbers[i], numbers[i - 1]);
        }
        System.out.println(count);
    }
}
