import java.util.HashMap;
import java.util.Map;

/**
 * @author bjenuhb
 */

public class P1347 {

    public int minSteps(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        for (Character ch: s.toCharArray()) {
            mapS.put(ch, mapS.computeIfAbsent(ch, c -> 0) + 1);
        }

        Map<Character, Integer> mapT = new HashMap<>();
        for (Character ch: t.toCharArray()) {
            mapT.put(ch, mapT.computeIfAbsent(ch, c -> 0) + 1);
        }

        int sum = 0;
        for (Character ch: mapS.keySet()) {
            sum += Math.max(mapS.computeIfAbsent(ch, c -> 0) - mapT.computeIfAbsent(ch, c -> 0), 0);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new P1347().minSteps("friend", "family"));
    }

}
