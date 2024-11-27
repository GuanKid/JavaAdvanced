package Book8.Chapter_1;

import java.io.File;
import java.io.IOException;

public class MyFile {

    public static void main(String[] args) {
        File f =new File("C:\\Bootcamp\\Java Bootcamp\\Java\\Advanced\\DummiesBook\\src\\Book8\\Chapter_1\\helloToYou.txt");
        if (f.exists())
        {
            System.out.println("File does exist");
        } else {
            System.out.println("File does not exist");
        }

        try {
            if (f.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File could not be created.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file.\nStack Trace:");
            e.printStackTrace(System.out);
        }

        File dir = new File("C:\\Bootcamp\\Java Bootcamp\\Java\\Advanced\\DummiesBook\\src\\Book8\\Chapter_1");

        if (dir.isDirectory()) {
            System.out.println("Yes it's a directory.\nHere is it's file contents:\n");
            File[] files = dir.listFiles();
            for (File myFile: files) {
                System.out.println(myFile.getName());
            }
        }


        if (f.renameTo(new File("C:\\Bootcamp\\Java Bootcamp\\Java\\Advanced\\DummiesBook\\src\\Book8\\Chapter_1\\helloToYou.txt"))) {
            System.out.println("File renamed.");
        } else {
            System.out.println("File unable to rename.");
        }

        if (f.delete( )) {
            System.out.println("File deleted.");
        } else {
            System.out.println("Unable to delete file.");
        }

    }
}
