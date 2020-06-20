import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author bjenuhb
 */

public class DistinctNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int num = scanner.nextInt();
            set.add(num);
        }
        System.out.println(set.size());
    }

}
