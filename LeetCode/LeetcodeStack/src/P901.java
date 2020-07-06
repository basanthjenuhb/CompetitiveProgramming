import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import static java.lang.String.valueOf;

/**
 * @author bjenuhb
 */



class MovingAverage {
    int size = 0;
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<>(size);
    }

    public double next(int val) {
        if (queue.size() == size) {
            queue.poll();
        }
        queue.offer(val);
        Iterator<Integer> iterator = queue.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum / (double) queue.size();
    }
}

class StockSpanner {

    List<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[list.size()];
        Arrays.fill(span, 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            int stock = list.get(i);
            while (!stack.isEmpty() && stock > list.get(stack.peek())) {
                span[stack.peek()] = stack.peek() - i;
                stack.pop();
            }
            stack.push(i);
        }
        return span[list.size() - 1];
    }
}

public class P901 {

    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();

    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        for (int[] dominoe: dominoes) {
            String str = dominoe[0] + String.valueOf(dominoe[1]);
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String finalString = new String(chars);
            if (map.get(finalString) == null) {
                map.put(finalString, 0);
            } else {
                map.put(finalString, map.get(finalString) + 1);
                count += map.get(finalString);
            }
        }
        return count;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x3 = rec2[0], y3 = rec2[1], x4 = rec2[2], y4 = rec2[3];

        if (x1 < x3 && x3 < x2 ) {
            if (y1 < y3 && y3 < y2) {
                return true;
            }
            if (y1 < y4 && y4 < y3) {
                return true;
            }
        }

        if (x3 < x1 && x1 < x4) {
            if (y3 < y1 && y1 < y2) {
                return true;
            }
            if (y1 < y3 && y3 < y2) {
                return true;
            }
        }

        return false;
    }

    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lastPosition = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            lastPosition.put(S.charAt(i), i);
        }

        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i < S.length()) {
            Character character = S.charAt(i);
            int j = i;
            int k = lastPosition.get(character);
            while (j < k) {
                j++;
                k = Math.max(k, lastPosition.get(S.charAt(j)));
            }
            list.add(k - i + 1);
            i = j;
        }
        return list;
    }

    public static void main(String[] args) {
//        StockSpanner obj = new StockSpanner();
//        System.out.println(obj.next(31));
//        System.out.println(obj.next(41));
//        System.out.println(obj.next(48));
//        System.out.println(obj.next(59));
//        System.out.println(obj.next(79));

//        MovingAverage movingAverage = new MovingAverage(3);
//        System.out.println(movingAverage.next(1));

        System.out.println(new P901().partitionLabels("ababcbacadefegdehijhklij"));

    }

}
