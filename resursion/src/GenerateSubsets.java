/**
 * @author bjenuhb
 */

public class GenerateSubsets {

    static void generateSubset(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        generateSubset(input.substring(1), output + input.substring(0, 1));
        generateSubset(input.substring(1), "");
    }

    public static void main(String[] args) {
        generateSubset("ABC", "");
    }

}
