import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author bjenuhb
 */

class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
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

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}

public class Apartments {

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int totalApplicants = fastReader.nextInt(), totalApartments = fastReader.nextInt(), allowedDifference =
            fastReader.nextInt();
        List<Integer> applicants = new ArrayList<>(totalApplicants);
        List<Integer> apartments = new ArrayList<>(totalApartments);
        for (int i = 0; i < totalApplicants; i++) {
            int num = fastReader.nextInt();
            applicants.add(num);
        }
        for (int i = 0; i < totalApartments; i++) {
            int num = fastReader.nextInt();
            apartments.add(num);
        }

        Collections.sort(apartments);
        Collections.sort(applicants);

        int i = 0, j = 0, count = 0;
        while (i < apartments.size() && j < applicants.size()) {
            if (Math.abs(apartments.get(i) - applicants.get(j)) <= allowedDifference) {
                count++;
                i++;
                j++;
            } else if (apartments.get(i) > applicants.get(j) + allowedDifference) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println(count);
    }

}
