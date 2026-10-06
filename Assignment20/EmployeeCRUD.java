import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/companydb";
    static final String USER = "root";
    static final String PASSWORD = "NewPass123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            int choice;

            do {
                System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
                System.out.println("1. Insert Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    // INSERT EMPLOYEE
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertSQL =
                                "INSERT INTO employee " +
                                "(emp_id, name, department, salary) " +
                                "VALUES (?, ?, ?, ?)";

                        try (PreparedStatement ps =
                                     con.prepareStatement(insertSQL)) {

                            ps.setInt(1, id);
                            ps.setString(2, name);
                            ps.setString(3, department);
                            ps.setDouble(4, salary);

                            ps.executeUpdate();

                            System.out.println(
                                    "Employee inserted successfully.");
                        }
                        break;

                    // DISPLAY EMPLOYEES
                    case 2:
                        String selectSQL = "SELECT * FROM employee";

                        try (Statement st = con.createStatement();
                             ResultSet rs = st.executeQuery(selectSQL)) {

                            System.out.println(
                                    "\nID\tName\tDepartment\tSalary");

                            while (rs.next()) {
                                System.out.println(
                                        rs.getInt("emp_id") + "\t" +
                                        rs.getString("name") + "\t" +
                                        rs.getString("department") + "\t" +
                                        rs.getDouble("salary")
                                );
                            }
                        }
                        break;

                    // UPDATE EMPLOYEE
                    case 3:
                        System.out.print(
                                "Enter Employee ID to update: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();

                        String updateSQL =
                                "UPDATE employee SET salary = ? " +
                                "WHERE emp_id = ?";

                        try (PreparedStatement ps =
                                     con.prepareStatement(updateSQL)) {

                            ps.setDouble(1, newSalary);
                            ps.setInt(2, updateId);

                            int updated = ps.executeUpdate();

                            if (updated > 0) {
                                System.out.println(
                                        "Employee updated successfully.");
                            } else {
                                System.out.println(
                                        "Employee not found.");
                            }
                        }
                        break;

                    // DELETE EMPLOYEE
                    case 4:
                        System.out.print(
                                "Enter Employee ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteSQL =
                                "DELETE FROM employee WHERE emp_id = ?";

                        try (PreparedStatement ps =
                                     con.prepareStatement(deleteSQL)) {

                            ps.setInt(1, deleteId);

                            int deleted = ps.executeUpdate();

                            if (deleted > 0) {
                                System.out.println(
                                        "Employee deleted successfully.");
                            } else {
                                System.out.println(
                                        "Employee not found.");
                            }
                        }
                        break;

                    // EXIT
                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 5);

            // Close database connection
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


