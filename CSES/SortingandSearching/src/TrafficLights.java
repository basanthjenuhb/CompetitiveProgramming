import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author bjenuhb
 */

class FastReader1
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader1()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws Exception {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
        }
        return str;
    }
}

public class TrafficLights {

    public static void main(String[] args) throws Exception {
        FastReader1 fastReader = new FastReader1();
        int streetLength = fastReader.nextInt(), totalLamps = fastReader.nextInt();
        int min = 0, max = streetLength, maxWidth = 0;
        StringBuilder result = new StringBuilder();
        List<Integer> lamps = new ArrayList<>(totalLamps);
        for (int i = 0; i < totalLamps; i++) {
            int nextNumber = fastReader.nextInt();
            boolean inserted = false;
            for (int k = 0; k < lamps.size(); k++) {
                if (lamps.get(k) > nextNumber) {
                    lamps.add(k, nextNumber);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                lamps.add(nextNumber);
            }
            int width = Integer.MIN_VALUE;
            for (int k = 0; k < lamps.size(); k++) {
                if (k == 0) {
                    width = lamps.get(k);
                }
                if (k == lamps.size() - 1) {
                    width = Math.max(streetLength - lamps.get(k), width);
                } else if (k > 0) {
                    width = Math.max(lamps.get(k) - lamps.get(k - 1), width);
                }
            }
            result.append(width).append(" ");
        }
        System.out.println(result);
    }

}
