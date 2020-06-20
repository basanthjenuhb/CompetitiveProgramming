import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class WordCombinations {

    public static int getCount(String[] dictionary, String targetWord, String currentWord, int position) {
        if (targetWord.equals(currentWord)) {
            return 1;
        }
        if (targetWord.length() < currentWord.length() || !targetWord.startsWith(currentWord)) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < dictionary.length; i++) {
            sum += getCount(dictionary, targetWord, currentWord + dictionary[i], i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String finalString = scanner.next();
        int totalWords = scanner.nextInt();
        String[] dictionary = new String[totalWords];
        for (int i = 0; i < totalWords; i++) {
            dictionary[i] = scanner.next();
        }
        System.out.println(getCount(dictionary, finalString, "", 0));
    }

}
