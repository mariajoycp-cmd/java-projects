import java.sql.*;

public class proud {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/productdb",
                "root",
                "NewPass123"
            );

            Statement stmt = con.createStatement();
            String query = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Product Details");
            System.out.println("==============================================");
            System.out.printf("%-8s %-16s %-10s %s%n", "ID", "Product Name", "Quantity", "Price");
            System.out.println("==============================================");

            while (rs.next()) {
                System.out.printf("%-8d %-16s %-10d %.1f%n",
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("quantity"),
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
