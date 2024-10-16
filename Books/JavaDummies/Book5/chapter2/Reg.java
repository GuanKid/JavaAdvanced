package Book_5.Chapter_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg
{
    static String r, s;
    static Pattern pattern;
    static Matcher matcher;
    static boolean match, validRegex, doneMatching;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Regex Tester\n");

        do {
            do {
                System.out.println("\nEnter regex: ");
                r = sc.nextLine();
                validRegex = true;

                try {
                    pattern = Pattern.compile(r);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    validRegex = false;
                }
            } while (!validRegex);
            doneMatching = false;
            while (!doneMatching)
            {
                System.out.println("Enter string: ");
                s = sc.nextLine();
                if (s.length() == 0)
                {
                    doneMatching = true;
                } else {
                    matcher = pattern.matcher(s);
                    if (matcher.matches())
                    {
                        System.out.println("Match");
                    } else {
                        System.out.println("Does not match");
                    }
                }
            }
        } while (askAgain());
    }

    private static boolean askAgain()
    {
        System.out.println("Another? (Y or N)");
        String reply = sc.nextLine();
        if (reply.equalsIgnoreCase("Y"))
            return true;
        return false;
    }

}
