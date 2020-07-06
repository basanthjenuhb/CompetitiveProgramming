import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bjenuhb
 */

public class LRUCache {

    int size;
    Deque<Integer> queue = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int size) {
        this.size = size;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            for (Integer value : queue) {
                if (value.equals(map.get(key))) {
                    queue.remove(map.get(key));
                    queue.offer(map.get(key));
                    return map.get(key);
                }
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        if (queue.size() == size) {
            Integer integer = queue.removeFirst();
            m
        }
    }

}
