package Book_5.Chapter_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
        // Can't just put regex inside a String, because the \ is an escape character.
        //String regex = "\w\d"; // error: won't compile

        // To fix the problem you need a set of double backslashes.
        String regex = "\\w\\d-\\w\\d"; // now it will // compile

        // Use split to split a string into a array of Strings based on a regex delimiter.
        String s = "One:Two;Three|Four\tFive";
        String regex2 = "[:;|\\t]";
        String strings[] = s.split(regex2);
        for (String word : strings)
            System.out.println(word);

        // Matches method is fine for occasional regex but if you want to go deeper
        // There is a Pattern and Matcher class.
        // Pattern represents the compiled version of a regular expression.
        // You can use the compiled Pattern to object to create a Matcher object.
        System.out.println(validDroidName2("r2-d2"));
        System.out.println(validDroidName2("r-3po"));
        System.out.println(validDroidName2("ra-ra"));
    }

    // Name of droid is passed in as a parameter and a boolean is passed.
    private static boolean validDroidName(String droid)
    {
        String regex = "(\\w\\d-\\w\\d)|(\\w-\\d\\w\\w)";
        return droid.matches(regex);
    }

    private static Pattern droidPattern;
    private static boolean validDroidName2(String droid)
    {
        if (droidPattern == null)
        {
            String regex = "(\\w\\d-\\w\\d)|"
                    + "(\\w-\\d\\w\\w)";
            // Saves the compiled regular expression as a pattern.
            droidPattern = Pattern.compile(regex);
        }
        // Uses the compiled regex pattern to match
        Matcher m = droidPattern.matcher(droid);
        return m.matches();
    }

}
