package Book8.Chapter_2;

import java.io.*;

public class WriteBinaryFile {

    public static void main(String[] args) {
        Movie[] movies = getMovies();
        DataOutputStream out = openOutputStream("C:\\Users\\Mark\\Documents\\Bootcamp\\6.Java\\Dummies_Book\\src\\Book_8\\Chapter_2\\movies.dat");
        for (Movie m : movies) {
            writeMovie(m, out);
        }
        closeFile(out);
    }

    private static Movie[] getMovies() {
        Movie[] movies = new Movie[10];
        movies[0] = new Movie("It's a Wonderful Life", 1946, 14.95);
        movies[1] = new Movie("Young Frankenstein", 1974, 16.95);
        movies[2] = new Movie("Star Wars", 1977, 17.95);
        movies[3] = new Movie("The Princess Bride", 1987, 16.95);
        movies[4] = new Movie("Glory", 1989, 14.95);
        movies[5] = new Movie("The Game", 1997, 14.95);
        movies[6] = new Movie("Shakespeare in Love", 1998, 19.95);
        movies[7] = new Movie("Zombieland", 1997, 18.95);
        movies[8] = new Movie("The King's Speech", 1997, 19.95);
        movies[9] = new Movie("Star Trek Into Darkness", 1997, 19.95);
        return movies;
    }

    private static DataOutputStream openOutputStream(String name) {
        DataOutputStream out = null;
        try {
            File file = new File(name);
            out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            System.out.println("I/O Exception opening file.");
            System.exit(0);
        }
        return out;
    }

    private static void writeMovie(Movie m, DataOutputStream out) {
        try {
            out.writeUTF(m.title);
            out.writeInt(m.year);
            out.writeDouble(m.price);
        } catch (IOException e) {
            System.out.println("I/O Exception writing data.");
            System.exit(0);
        }
    }

    private static void closeFile(DataOutputStream out) {
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("I/O Exception closing file.");
            System.exit(0);
        }
    }

    private static class Movie
    {
        public String title;
        public int year;
        public double price;
        public Movie(String title, int year, double price)
        {
            this.title = title;
            this.year = year;
            this.price = price;
        }
    }

}
