import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class CountingBits {

    static Map<Long, Long> countMap = new HashMap<>();

    public static long count(long number) {
        int count = 0;
        while (number != 0) {
            if (countMap.get(number) != null) {
                return countMap.get(number) + count;
            }
            number = number & (number - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        long output = 0;
        for (long i = 1; i <= input; i++) {
            long result = count(i);
            countMap.put(i, result);
            output += result;
        }
        System.out.println(output);
    }

}
