import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bjenuhb
 */

public class P890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if (word.length() != pattern.length()) {
                continue;
            }
            Map<Character, Character> patternToCharacterMap = new HashMap<>();
            Map<Character, Character> characterToPatternMap = new HashMap<>();
            boolean success = true;
            for (int i = 0; i < pattern.length(); i++) {
                char pch = pattern.charAt(i);
                char wch = word.charAt(i);
                if (patternToCharacterMap.computeIfAbsent(pch, w -> wch) != wch
                    || characterToPatternMap.computeIfAbsent(wch, w -> pch) != pch) {
                    success = false;
                    break;
                }
            }
            if (success) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        System.out.println(new P890().findAndReplacePattern(input, "abb"));
    }

}
