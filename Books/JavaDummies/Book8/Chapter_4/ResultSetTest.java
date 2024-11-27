package Book8.Chapter_4;

import java.sql.*;

public class ResultSetTest
{

    public static void main(String[] args) {
        Connection con = getConnection();

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("SELECT * FROM movie");
//             Delete a row
//            rs.absolute(4);
//            rs.deleteRow();
//            System.out.println("Successfully Deleted Row 3");

//            // Update a row
//            rs.absolute(6);
//            rs.updateInt("year", 1975);
//            rs.updateRow();
//            System.out.println("Updated row 6 to year 1975");
//

//            // Insert a row
            rs.moveToInsertRow();
            rs.updateString("title", "Monty Python and the Holy Grail");
            rs.updateInt("year", 1975);
            rs.updateDouble("price", 13.95);
            rs.insertRow();
            rs.moveToCurrentRow();
            System.out.println("Inserted a new row");

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
