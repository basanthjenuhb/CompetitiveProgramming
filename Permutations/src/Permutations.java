import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class Permutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        if (total == 2 || total == 3) {
            System.out.println("NO SOLUTION");
            System.exit(0);
        }
        if (total == 4) {
            System.out.println("2 4 1 3 ");
            System.exit(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= total; i = i + 2) {
            stringBuilder.append(i).append(" ");
        }
        for (int i = 2; i <= total; i =  i + 2) {
            stringBuilder.append(i).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

}
