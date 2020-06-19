import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class NumberSpiral {

    public static Object getNumber(long x, long y) {
        long max = Math.max(x, y);
        long min = Math.min(x, y);
        return BigDecimal.valueOf(max).toBigInteger().pow(2)
            .subtract(BigInteger.valueOf(min))
            .add(BigInteger.valueOf(1));
    }

    public static void main(String[] args) {

        long x, y, t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextLong();
        StringBuilder stringBuilder = new StringBuilder();
        while (t-- != 0) {
            x = scanner.nextLong();
            y = scanner.nextLong();
            Object number = getNumber(x, y);
            stringBuilder.append(number).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
