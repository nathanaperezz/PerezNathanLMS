//Nathan Perez
//Library management system

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:/Users/nathanperez/Desktop/SQLite/Library.db"; 
        String uname = "nathanperez";
        String password = "Salem";
        String query = "SELECT * FROM books";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url, uname, password);
            System.out.println("Connection to SQLite has been established.");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()) {
                String booksData = "";
                for(int i = 1; i <= 6; i++) {
                    booksData += result.getString(i) + ":";
                }
                System.out.println(booksData);
            }

            // Close resources
            result.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred:");
            e.printStackTrace();
        }
    }
}


