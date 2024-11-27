package Book8.Chapter_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class FileVisitorDemo
{
    public static void main(String[] args) {
        Path start = Paths.get("C:\\Windows\\System32");
        MyFileVisitor visitor = new MyFileVisitor();
        try {
            Files.walkFileTree(start, visitor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
            System.out.println(file.toString() + " ACCESSED");
            return FileVisitResult.CONTINUE;
        }


        public FileVisitResult visitFileFailed(Path file, IOException e) {
            System.out.println(file.toString() + " COULD NOT ACCESS!");
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attr) throws IOException {
//            if (!Files.isDirectory(dir))
//                System.out.println(dir.toString() + " Before Visiting the Directory ");
            return FileVisitResult.CONTINUE;
        }

    }
}
