import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bjenuhb
 */

public class Atoi {

    public int myAtoi(String str) {

        Pattern pattern = Pattern.compile("^(\\s)?([+-])?(\\d+)?");
        Matcher matcher = pattern.matcher(str);
        String group = matcher.group(0);
        System.out.println(group);
        return 0;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("21"));
    }

}
