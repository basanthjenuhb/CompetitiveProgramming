import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author bjenuhb
 */

public class P1436 {

    public String destCity(List<List<String>> paths) {
        Map<String, Set<String>> pathMap = new HashMap<>();
        for (List<String> path: paths) {
            String source = path.get(0);
            String destination = path.get(1);
            Set<String> destinations = pathMap.computeIfAbsent(source, s -> new HashSet<>());
            destinations.add(destination);
            pathMap.computeIfAbsent(destination, s -> new HashSet<>());
        }
        for (String city: pathMap.keySet()) {
            if (pathMap.get(city).size() == 0) {
                return city;
            }
        }
        return null;
    }

}
