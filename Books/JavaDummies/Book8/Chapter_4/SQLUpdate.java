package Book8.Chapter_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUpdate
{
    public static void main(String[] args) {
        loanMovie(3, "Drinkwater", "Mark");
    }

    private static void loanMovie(int id, String lastName, String firstName)
    {
        Connection con = getConnection();
        try
        {
            Statement stmt = con.createStatement();
            String insert = "INSERT INTO FRIEND " +
                            "(lastname,firstname,movieid) " +
                            "VALUES (" + "\"" + lastName + "\", \""
                            + firstName + "\", " + id + ")";


            int result = stmt.executeUpdate(insert);

            if (result == 1) {
                System.out.println("Loan recorded");
            } else {
                System.out.println("Loan not recorded.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
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
}
