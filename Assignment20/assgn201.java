import java.sql.*;

public class assgn201 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/studentdb";
        String username = "root";
        String password = "NewPass123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                url, username, password
            );
            System.out.println("Database connected successfully.");

            Statement stmt = con.createStatement();

            // INSERT
            String insert =
                "INSERT INTO student VALUES (101, 'Maria', 85)";
            stmt.executeUpdate(insert);
            System.out.println("Record inserted successfully.");

            // UPDATE
            String update =
                "UPDATE student SET marks = 90 WHERE id = 101";
            stmt.executeUpdate(update);
            System.out.println("Record updated successfully.");

            // DELETE
            String delete =
                "DELETE FROM student WHERE id = 101";
            stmt.executeUpdate(delete);
            System.out.println("Record deleted successfully.");

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}