import java.sql.*;

public class assgn19 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cardb",
                "root",
                "NewPass123"
            );

            Statement stmt = con.createStatement();
            String query = "SELECT * FROM cars";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Car Records");
            System.out.println("==========================================");
            System.out.printf("%-8s %-14s %-14s %s%n", "ID", "Brand", "Model", "Price");
            System.out.println("==========================================");

            while (rs.next()) {
                System.out.printf("%-8d %-14s %-14s %.1f%n",
                    rs.getInt("car_id"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getDouble("price"));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
