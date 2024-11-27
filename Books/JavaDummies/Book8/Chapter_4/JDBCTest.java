package Book8.Chapter_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

    public static void main(String[] args) {
            Connection con = getconnection();
    }

    private static Connection getconnection()
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
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("SUCCESSFUL CONNECTION!");
        return con;
    }

}
