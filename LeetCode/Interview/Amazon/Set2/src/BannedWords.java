import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bjenuhb
 */

public class BannedWords {

    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder finalString = new StringBuilder();
        for (Character ch: paragraph.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isWhitespace(ch)) {
                finalString.append(ch);
            } else {
                finalString.append(" ");
            }
        }
        String[] words = finalString.toString().split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> bannedWords = new HashSet<>();
        for (String bannedWord: banned) {
            bannedWords.add(bannedWord.toLowerCase());
        }
        for (String word: words) {
            if (!bannedWords.contains(word) && word.trim().length() > 0) {
                Integer count = wordCount.computeIfAbsent(word, w -> 0);
                wordCount.put(word, count + 1);
            }
        }
        String result = null;
        Integer maxCount = Integer.MIN_VALUE;
        for (String str: wordCount.keySet()) {
            if (wordCount.get(str) > maxCount) {
                maxCount = wordCount.get(str);
                result = str;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = new BannedWords().mostCommonWord("a, a, a, a, b,b,b,c, c",
            new String[]{"a"});
        System.out.println(s);
    }

}
