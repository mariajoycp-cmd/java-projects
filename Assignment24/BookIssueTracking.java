import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BookIssueTracking extends JFrame {

    JTextField bookId, studentName, issueDate, returnDate;
    JTextArea output;
    Connection con;

    BookIssueTracking() {
        setTitle("Book Issue Tracking System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo",
                "root",
                "NewPass123"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Database connection failed: " + e.getMessage()
            );
        }

        bookId = new JTextField(10);
        studentName = new JTextField(10);
        issueDate = new JTextField(10);
        returnDate = new JTextField(10);
        output = new JTextArea(12, 48);
        output.setEditable(false);

        add(new JLabel("Book ID:"));
        add(bookId);
        add(new JLabel("Student Name:"));
        add(studentName);
        add(new JLabel("Issue Date (YYYY-MM-DD):"));
        add(issueDate);
        add(new JLabel("Return Date (YYYY-MM-DD):"));
        add(returnDate);

        JButton addBtn = new JButton("Add Record");
        JButton displayBtn = new JButton("Display Records");
        JButton updateBtn = new JButton("Update Record");
        JButton deleteBtn = new JButton("Delete Record");

        add(addBtn);
        add(displayBtn);
        add(updateBtn);
        add(deleteBtn);
        add(new JScrollPane(output));

        addBtn.addActionListener(e -> manageRecord(1));
        updateBtn.addActionListener(e -> manageRecord(2));

        deleteBtn.addActionListener(e -> {
            if (!checkConnection()) return;

            try (PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM BookIssue WHERE book_id=?")) {

                ps.setInt(1, Integer.parseInt(bookId.getText()));

                output.setText(ps.executeUpdate() > 0
                    ? "Record deleted successfully."
                    : "Record not found.");

            } catch (Exception ex) {
                showError(ex);
            }
        });

        displayBtn.addActionListener(e -> displayRecords());

        setVisible(true);
    }

    boolean checkConnection() {
        if (con == null) {
            showError(new Exception("Database is not connected."));
            return false;
        }
        return true;
    }

    void manageRecord(int operation) {
        if (!checkConnection()) return;

        String query = operation == 1
            ? "INSERT INTO BookIssue VALUES(?,?,?,?)"
            : "UPDATE BookIssue SET student_name=?, issue_date=?, return_date=? WHERE book_id=?";

        try (PreparedStatement ps = con.prepareStatement(query)) {

            if (operation == 1) {
                ps.setInt(1, Integer.parseInt(bookId.getText()));
                ps.setString(2, studentName.getText());
                ps.setDate(3, Date.valueOf(issueDate.getText()));
                ps.setDate(4, Date.valueOf(returnDate.getText()));
            } else {
                ps.setString(1, studentName.getText());
                ps.setDate(2, Date.valueOf(issueDate.getText()));
                ps.setDate(3, Date.valueOf(returnDate.getText()));
                ps.setInt(4, Integer.parseInt(bookId.getText()));
            }

            output.setText(ps.executeUpdate() > 0
                ? "Record saved successfully."
                : "No record found to update.");

        } catch (Exception ex) {
            showError(ex);
        }
    }

    void displayRecords() {
        if (!checkConnection()) return;

        output.setText("");

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM BookIssue")) {

            while (rs.next()) {
                output.append(
                    "Book ID: " + rs.getInt("book_id") +
                    "\nStudent: " + rs.getString("student_name") +
                    "\nIssue Date: " + rs.getDate("issue_date") +
                    "\nReturn Date: " + rs.getDate("return_date") +
                    "\n------------------------------\n"
                );
            }

            if (output.getText().isEmpty()) {
                output.setText("No issue records found.");
            }

        } catch (Exception ex) {
            showError(ex);
        }
    }

    void showError(Exception e) {
        JOptionPane.showMessageDialog(
            this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookIssueTracking());
    }
}
