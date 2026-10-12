import java.sql.*;
import java.util.Scanner;

public class HospitalLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "NewPass123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            System.out.print("Enter Login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            String sql = "SELECT role FROM staff WHERE login_id=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, loginId);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");

                System.out.println("Login successful.");

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Access granted to Doctor.");
                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Access granted to Nurse.");
                } else {
                    System.out.println("Access denied. Unknown role.");
                }
            } else {
                System.out.println("Invalid Login ID or Password.");
                System.out.println("Access denied.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}