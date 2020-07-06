import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bjenuhb
 */

public class PatternMatching {

    public static void main(String[] args) {
        Pattern compile = Pattern.compile("OTP \\d{5}");
        Matcher matcher = compile.matcher("zdvsdcsd OTP 12345 hello");

        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

}
