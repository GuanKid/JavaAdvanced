package Book8.Chapter_1;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest
{
    public static void main(String[] args) {
        Path c = Paths.get("C:\\Users");

        try
        {
            DirectoryStream<Path> stream = Files.newDirectoryStream(c, "*.txt");

            for (Path entry: stream)
                System.out.println(entry.getFileName());
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
