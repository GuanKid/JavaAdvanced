package Book8.Chapter_4;

import java.sql.*;
import java.text.NumberFormat;

public class ListMovies
{
    private static Connection con;

    public static void main(String[] args) {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        ResultSet movies = getMovies();
        try
        {
            while (movies.next())
            {
                Movie m = getMovie(movies);
                String msg = Integer.toString(m.year);
                msg += ": " + m.title;
                msg += " (" + cf.format(m.price) + ")";
                System.out.println(msg);
            }

            try
            {
                con.close();
                System.out.println("Connection closed.");
            } catch (Exception e) {
                System.out.println("Error closing database.");
            }

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static ResultSet getMovies()
    {
        con = getConnection();
        try
        {
            Statement s = con.createStatement();
            String select = "SELECT * FROM movie ORDER BY year";
            ResultSet rows;
            rows = s.executeQuery(select);
            return rows;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("org.postgresql.Driver");  // PostgreSQL driver
            String url = "jdbc:postgresql://localhost:5432/movies";  // PostgreSQL URL format
            String user = "postgres";  // Your PostgreSQL username
            String pw = "Ndapinda@22";  // Your PostgreSQL password
            con = DriverManager.getConnection(url, user, pw);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return con;
    }

    private static Movie getMovie(ResultSet movies)
    {
        try
        {
            String title = movies.getString("Title");
            int year = movies.getInt("Year");
            double price = movies.getDouble("Price");
            return new Movie(title, year, price);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
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
