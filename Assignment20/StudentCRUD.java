import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "NewPass123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            int choice;

            do {
                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Create / Insert Student");
                System.out.println("2. Read / Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    // CREATE / INSERT
                    case 1:
                        System.out.print("Enter Roll Number: ");
                        int rollNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        String insertSQL =
                                "INSERT INTO student " +
                                "(roll_no, name, course, marks) " +
                                "VALUES (?, ?, ?, ?)";

                        PreparedStatement ps1 =
                                con.prepareStatement(insertSQL);

                        ps1.setInt(1, rollNo);
                        ps1.setString(2, name);
                        ps1.setString(3, course);
                        ps1.setDouble(4, marks);

                        ps1.executeUpdate();

                        System.out.println(
                                "Student record inserted successfully.");

                        break;

                    // READ / DISPLAY
                    case 2:
                        String selectSQL =
                                "SELECT * FROM student";

                        Statement st =
                                con.createStatement();

                        ResultSet rs =
                                st.executeQuery(selectSQL);

                        System.out.println(
                                "\nRoll No\tName\tCourse\tMarks");
                        System.out.println(
                                "--------------------------------------");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("roll_no") + "\t" +
                                    rs.getString("name") + "\t" +
                                    rs.getString("course") + "\t" +
                                    rs.getDouble("marks")
                            );
                        }

                        break;

                    // UPDATE
                    case 3:
                        System.out.print(
                                "Enter Roll Number to update: ");

                        int updateRoll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        String updateSQL =
                                "UPDATE student SET name=?, course=?, " +
                                "marks=? WHERE roll_no=?";

                        PreparedStatement ps2 =
                                con.prepareStatement(updateSQL);

                        ps2.setString(1, newName);
                        ps2.setString(2, newCourse);
                        ps2.setDouble(3, newMarks);
                        ps2.setInt(4, updateRoll);

                        int updated =
                                ps2.executeUpdate();

                        if (updated > 0) {
                            System.out.println(
                                    "Student record updated successfully.");
                        } else {
                            System.out.println(
                                    "Student record not found.");
                        }

                        break;

                    // DELETE
                    case 4:
                        System.out.print(
                                "Enter Roll Number to delete: ");

                        int deleteRoll = sc.nextInt();

                        String deleteSQL =
                                "DELETE FROM student WHERE roll_no=?";

                        PreparedStatement ps3 =
                                con.prepareStatement(deleteSQL);

                        ps3.setInt(1, deleteRoll);

                        int deleted =
                                ps3.executeUpdate();

                        if (deleted > 0) {
                            System.out.println(
                                    "Student record deleted successfully.");
                        } else {
                            System.out.println(
                                    "Student record not found.");
                        }

                        break;

                    // EXIT
                    case 5:
                        System.out.println(
                                "Exiting program...");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice.");
                }

            } while (choice != 5);

            // Close resources
            con.close();
            sc.close();

        } catch (ClassNotFoundException e) {

            System.out.println(
                    "JDBC Driver not found.");

        } catch (SQLException e) {

            System.out.println(
                    "Database Error: " + e.getMessage());
        }
    }
}

