package Book5.chapter3;

import java.io.File;
import java.util.Scanner;

public class DirList
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Directory Lister.");

        do {
            System.out.print("\nEnter a path: ");
            String path = sc.nextLine();

            File dir = new File(path);

            if (!dir.exists() || !dir.isDirectory()) {
                System.out.println("\nThat directory doesn't exist");

            } else {
                System.out.println("\nListing directory tree of:");
                System.out.println(dir.getPath());
                listDirectories(dir, " ");
            }

        } while (askAgain());
    }

    private static void listDirectories(File dir, String indent) {
        File[] dirs = dir.listFiles();
        for (File f: dirs)
        {
            if (f.isDirectory())
            {
                System.out.println(indent + f.getName());
                listDirectories(f, indent + "   ");
            }
        }
    }
    private static boolean askAgain()
    {
        System.out.print("Another? (Y or N) ");
        String reply = sc.nextLine();
        if (reply.equalsIgnoreCase("Y"))
            return true;
        return false;
    }
}
