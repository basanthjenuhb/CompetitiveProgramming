import java.util.HashSet;
import java.util.Set;

/**
 * @author bjenuhb
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int i = 0, j = 0;
        int longest = 0;
        while (j < s.length()) {
            if (!seen.contains(s.charAt(j))) {
                seen.add(s.charAt(j++));
                longest = Math.max(longest, seen.size());
            } else {
                seen.remove(s.charAt(i++));
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solve =
            new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solve.lengthOfLongestSubstring("tmmtmzuxt"));
    }

}
