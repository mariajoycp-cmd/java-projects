
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class assgn24 extends JFrame {

    JTextField id, name, dept, salary;
    JTextArea output;
    Connection con;

    assgn24() {
        setTitle("Employee Management System");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo",
                "root",
                "NewPass123"
            );
            System.out.println("Database connected successfully!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this, "Database connection failed: " + e.getMessage()
            );
        }

        id = new JTextField(10);
        name = new JTextField(10);
        dept = new JTextField(10);
        salary = new JTextField(10);
        output = new JTextArea(10, 40);
        output.setEditable(false);

        add(new JLabel("Employee ID:"));
        add(id);
        add(new JLabel("Name:"));
        add(name);
        add(new JLabel("Department:"));
        add(dept);
        add(new JLabel("Salary:"));
        add(salary);

        JButton insert = new JButton("Insert");
        JButton display = new JButton("Display");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");

        add(insert);
        add(display);
        add(update);
        add(delete);
        add(new JScrollPane(output));

        insert.addActionListener(e ->
            execute("INSERT INTO Employee VALUES(?,?,?,?)", false));

        update.addActionListener(e ->
            execute("UPDATE Employee SET name=?, department=?, salary=? WHERE emp_id=?", true));

        delete.addActionListener(e -> {
            if (!checkConnection()) return;

            try (PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Employee WHERE emp_id=?")) {

                ps.setInt(1, Integer.parseInt(id.getText()));

                output.setText(ps.executeUpdate() > 0
                    ? "Employee deleted successfully."
                    : "Employee not found.");

            } catch (Exception ex) {
                showError(ex);
            }
        });

        display.addActionListener(e -> {
            if (!checkConnection()) return;

            output.setText("");

            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM Employee")) {

                while (rs.next()) {
                    output.append(
                        "ID: " + rs.getInt("emp_id") +
                        ", Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department") +
                        ", Salary: " + rs.getDouble("salary") + "\n"
                    );
                }

                if (output.getText().isEmpty()) {
                    output.setText("No employee records found.");
                }

            } catch (Exception ex) {
                showError(ex);
            }
        });

        setVisible(true);
    }

    boolean checkConnection() {
        if (con == null) {
            showError(new Exception(
                "Database is not connected. Check MySQL settings."
            ));
            return false;
        }
        return true;
    }

    void execute(String query, boolean update) {
        if (!checkConnection()) return;

        try (PreparedStatement ps = con.prepareStatement(query)) {

            if (update) {
                ps.setString(1, name.getText());
                ps.setString(2, dept.getText());
                ps.setDouble(3, Double.parseDouble(salary.getText()));
                ps.setInt(4, Integer.parseInt(id.getText()));
            } else {
                ps.setInt(1, Integer.parseInt(id.getText()));
                ps.setString(2, name.getText());
                ps.setString(3, dept.getText());
                ps.setDouble(4, Double.parseDouble(salary.getText()));
            }

            output.setText(ps.executeUpdate() > 0
                ? "Operation completed successfully."
                : "No records affected.");

        } catch (Exception ex) {
            showError(ex);
        }
    }

    void showError(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new assgn24());
    }
}
