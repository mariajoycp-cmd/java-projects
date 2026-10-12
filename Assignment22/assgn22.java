import java.sql.*;

public class assgn22 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/jdbc_demo",
            "root",
            "NewPass123"
        );

        System.out.println("Student database connected successfully.");

        Statement stmt = con.createStatement();
        System.out.println("Statement created successfully.");

        stmt.close();
        con.close();
    }
}