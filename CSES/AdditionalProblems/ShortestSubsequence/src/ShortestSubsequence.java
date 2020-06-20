import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @author bjenuhb
 */

public class ShortestSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Integer count = countMap.computeIfAbsent(input.charAt(i), c -> 0);
            count++;
            countMap.put(input.charAt(i), count);
        }
        Set<Entry<Character, Integer>> entries = countMap.entrySet();

        int min = Integer.MAX_VALUE;
        Character target = null;
        for (Entry<Character, Integer> entry: entries) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                target = entry.getKey();
            }
        }
        for (int i = 0; i <= min; i++) {
            System.out.print(target);
        }
    }

}
